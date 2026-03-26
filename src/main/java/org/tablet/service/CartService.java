package org.tablet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tablet.dto.CartItemDto;
import org.tablet.dto.CartResultDto;
import org.tablet.persistence.ProductRepository;
import org.tablet.persistence.entity.Offer;
import org.tablet.persistence.entity.Product;

import java.util.*;

@Service
public class CartService {

    private final ProductRepository productRepository;

    @Autowired
    public CartService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<CartResultDto> calculateCart(List<Long> productIds) {
        List<Product> products = productRepository.findAllById(productIds);

        if (products.size() < productIds.size()) {
            throw new RuntimeException("Eroare: Unul sau mai multe produse din coș nu există în baza de date!");
        }
        List<CartResultDto> options = new ArrayList<>();

        if (products.isEmpty()) {
            return options;
        }

        double minTotalMixed = 0;
        List<CartItemDto> mixedItems = new ArrayList<>();

        for (Product product : products) {
            Offer ceaMaiIeftinaOferta = product.getOffers().stream()
                    .min(Comparator.comparingDouble(Offer::getPrice))
                    .orElse(null);

            if (ceaMaiIeftinaOferta != null) {
                minTotalMixed += ceaMaiIeftinaOferta.getPrice();
                mixedItems.add(new CartItemDto(product.getName(), ceaMaiIeftinaOferta.getStoreName(), ceaMaiIeftinaOferta.getPrice()));
            }
        }

        double rotunjitMix = Math.round(minTotalMixed * 100.0) / 100.0;
        options.add(new CartResultDto("Cea mai ieftină variantă", mixedItems, rotunjitMix));


        Set<String> allStores = new HashSet<>();
        for (Product p : products) {
            for (Offer o : p.getOffers()) {
                allStores.add(o.getStoreName());
            }
        }

        for (String store : allStores) {
            double storeTotal = 0;
            boolean storeHasAllProducts = true;
            List<CartItemDto> storeItems = new ArrayList<>();

            for (Product p : products) {
                Optional<Offer> offerFromThisStore = p.getOffers().stream()
                        .filter(o -> o.getStoreName().equalsIgnoreCase(store))
                        .findFirst();

                if (offerFromThisStore.isPresent()) {
                    Offer offer = offerFromThisStore.get();
                    storeTotal += offer.getPrice();
                    storeItems.add(new CartItemDto(p.getName(), offer.getStoreName(), offer.getPrice()));
                } else {
                    storeHasAllProducts = false;
                    break;
                }
            }

            if (storeHasAllProducts) {
                double rotunjitStore = Math.round(storeTotal * 100.0) / 100.0;
                options.add(new CartResultDto("Totul de la " + store.toUpperCase(), storeItems, rotunjitStore));
            }
        }

        options.sort(Comparator.comparingDouble(CartResultDto::totalPrice));

        return options;
    }
}