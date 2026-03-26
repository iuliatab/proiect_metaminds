package org.tablet.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tablet.persistence.entity.Offer;
import org.tablet.persistence.ProductRepository;
import org.tablet.persistence.entity.Product;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product produsNou) {
        System.out.println("Postman a trimis produsul: " + produsNou.getName());

        if (produsNou.getOffers() != null) {
            for (Offer oferta : produsNou.getOffers()) {
                oferta.setProduct(produsNou);
            }
        }

        Product produsSalvat = productRepository.save(produsNou);
        return ResponseEntity.ok(produsSalvat);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String query) {

        System.out.println("Frontend-ul a căutat: " + query);

        List<Product> produseGasite = productRepository.findByNameContainingIgnoreCase(query);

        return ResponseEntity.ok(produseGasite);
    }
}