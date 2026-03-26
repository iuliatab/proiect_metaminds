package org.tablet.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.tablet.persistence.entity.Offer;
import org.tablet.persistence.entity.Product;
import org.tablet.persistence.ProductRepository;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataSeeder(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (productRepository.count() == 0) {
            System.out.println("Baza de date este goală. Începem popularea automată cu produse reale...");

                //1
                Product telefon = new Product(); telefon.setName("Apple iPhone 15 Pro, 256GB, Titanium");
                Offer telEmag = new Offer(); telEmag.setStoreName("eMAG"); telEmag.setPrice(6199.99);
                Offer telAltex = new Offer(); telAltex.setStoreName("Altex"); telAltex.setPrice(6099.90);
                Offer telFlanco = new Offer(); telFlanco.setStoreName("Flanco"); telFlanco.setPrice(6249.00);
                telefon.setOffers(List.of(telEmag, telAltex, telFlanco));

                //2
                Product laptop = new Product(); laptop.setName("Laptop Gaming ASUS ROG Strix G16");
                Offer lapEmag = new Offer(); lapEmag.setStoreName("eMAG"); lapEmag.setPrice(7499.00);
                Offer lapAltex = new Offer(); lapAltex.setStoreName("Altex"); lapAltex.setPrice(7650.00);
                laptop.setOffers(List.of(lapEmag, lapAltex));

                //3
                Product tableta = new Product(); tableta.setName("Apple iPad Pro 11-inch (M4), 256GB");
                Offer tabEmag = new Offer(); tabEmag.setStoreName("eMAG"); tabEmag.setPrice(5299.00);
                Offer tabAltex = new Offer(); tabAltex.setStoreName("Altex"); tabAltex.setPrice(5350.00);
                tableta.setOffers(List.of(tabEmag, tabAltex));

                //4
                Product casti = new Product(); casti.setName("Casti Bluetooth Sony WH-1000XM5");
                Offer castiEmag = new Offer(); castiEmag.setStoreName("eMAG"); castiEmag.setPrice(1499.99);
                Offer castiFlanco = new Offer(); castiFlanco.setStoreName("Flanco"); castiFlanco.setPrice(1350.00);
                casti.setOffers(List.of(castiEmag, castiFlanco));

                //5
                Product ceas = new Product(); ceas.setName("Smartwatch Apple Watch Series 9, GPS, 45mm");
                Offer ceasEmag = new Offer(); ceasEmag.setStoreName("eMAG"); ceasEmag.setPrice(2199.00);
                Offer ceasAltex = new Offer(); ceasAltex.setStoreName("Altex"); ceasAltex.setPrice(2099.00);
                Offer ceasFlanco = new Offer(); ceasFlanco.setStoreName("Flanco"); ceasFlanco.setPrice(2250.00);
                ceas.setOffers(List.of(ceasEmag, ceasAltex, ceasFlanco));

                //6
                Product soundbar = new Product(); soundbar.setName("Soundbar JBL Bar 500, 5.1, 590W, Dolby Atmos");
                Offer sbEmag = new Offer(); sbEmag.setStoreName("eMAG"); sbEmag.setPrice(2499.90);
                Offer sbAltex = new Offer(); sbAltex.setStoreName("Altex"); sbAltex.setPrice(2499.90);
                soundbar.setOffers(List.of(sbEmag, sbAltex));

                //7
                Product ps5 = new Product(); ps5.setName("Consola PlayStation 5 (PS5) Disc Edition");
                Offer ps5Emag = new Offer(); ps5Emag.setStoreName("eMAG"); ps5Emag.setPrice(2699.00);
                Offer ps5Altex = new Offer(); ps5Altex.setStoreName("Altex"); ps5Altex.setPrice(2599.90);
                Offer ps5Flanco = new Offer(); ps5Flanco.setStoreName("Flanco"); ps5Flanco.setPrice(2750.00);
                ps5.setOffers(List.of(ps5Emag, ps5Altex, ps5Flanco));

                //8
                Product controller = new Product(); controller.setName("Controller Wireless Sony DualSense PS5");
                Offer ctrlEmag = new Offer(); ctrlEmag.setStoreName("eMAG"); ctrlEmag.setPrice(349.99);
                Offer ctrlAltex = new Offer(); ctrlAltex.setStoreName("Altex"); ctrlAltex.setPrice(329.90);
                controller.setOffers(List.of(ctrlEmag, ctrlAltex));

                //9
                Product tv = new Product(); tv.setName("Televizor Smart Samsung 4K, 138 cm");
                Offer tvEmag = new Offer(); tvEmag.setStoreName("eMAG"); tvEmag.setPrice(2299.00);
                Offer tvAltex = new Offer(); tvAltex.setStoreName("Altex"); tvAltex.setPrice(2150.00);
                tv.setOffers(List.of(tvEmag, tvAltex));

                //10
                Product espressor = new Product(); espressor.setName("Espressor automat De'Longhi Magnifica S");
                Offer espEmag = new Offer(); espEmag.setStoreName("eMAG"); espEmag.setPrice(1549.90);
                Offer espFlanco = new Offer(); espFlanco.setStoreName("Flanco"); espFlanco.setPrice(1600.00);
                espressor.setOffers(List.of(espEmag, espFlanco));

                //11
                Product aspirator = new Product(); aspirator.setName("Aspirator Robot Roborock S8, Mop, 6000 Pa");
                Offer aspEmag = new Offer(); aspEmag.setStoreName("eMAG"); aspEmag.setPrice(2899.00);
                Offer aspAltex = new Offer(); aspAltex.setStoreName("Altex"); aspAltex.setPrice(2950.00);
                Offer aspFlanco = new Offer(); aspFlanco.setStoreName("Flanco"); aspFlanco.setPrice(2850.00);
                aspirator.setOffers(List.of(aspEmag, aspAltex, aspFlanco));

                //12
                Product airfryer = new Product(); airfryer.setName("Friteuza cu aer cald Philips Airfryer XXL");
                Offer airEmag = new Offer(); airEmag.setStoreName("eMAG"); airEmag.setPrice(899.99);
                Offer airAltex = new Offer(); airAltex.setStoreName("Altex"); airAltex.setPrice(850.00);
                airfryer.setOffers(List.of(airEmag, airAltex));

                //13
                Product frigider = new Product(); frigider.setName("Combina frigorifica LG, No Frost, 384 l");
                Offer frigEmag = new Offer(); frigEmag.setStoreName("eMAG"); frigEmag.setPrice(2399.00);
                Offer frigAltex = new Offer(); frigAltex.setStoreName("Altex"); frigAltex.setPrice(2299.90);
                frigider.setOffers(List.of(frigEmag, frigAltex));

                //14
                Product masinaSpalat = new Product(); masinaSpalat.setName("Masina de spalat rufe Bosch, 9 kg, 1400 RPM");
                Offer msEmag = new Offer(); msEmag.setStoreName("eMAG"); msEmag.setPrice(2199.00);
                Offer msFlanco = new Offer(); msFlanco.setStoreName("Flanco"); msFlanco.setPrice(2099.00);
                masinaSpalat.setOffers(List.of(msEmag, msFlanco));

                //15
                Product trotineta = new Product(); trotineta.setName("Trotineta electrica Xiaomi Mi Pro 2");
                Offer trotEmag = new Offer(); trotEmag.setStoreName("eMAG"); trotEmag.setPrice(2150.00);
                Offer trotAltex = new Offer(); trotAltex.setStoreName("Altex"); trotAltex.setPrice(2199.90);
                trotineta.setOffers(List.of(trotEmag, trotAltex));


            List<Product> toateProdusele = List.of(
                    telefon, laptop, tableta, casti, ceas, soundbar, ps5, controller,
                    tv, espressor, aspirator, airfryer, frigider, masinaSpalat, trotineta
            );

            for (Product p : toateProdusele) {
                if (p.getOffers() != null) {
                    for (Offer o : p.getOffers()) {
                        o.setProduct(p);
                    }
                }
            }
            productRepository.saveAll(toateProdusele);

            System.out.println("Popularea automată a fost finalizată cu succes!");
        } else {
            System.out.println("Baza de date conține deja date. Sărim peste populare.");
        }
    }
}