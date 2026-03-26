package org.tablet.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tablet.dto.CartResultDto;
import org.tablet.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<?> calculateCart(@RequestBody List<Long> productIds) {
        try {

            return ResponseEntity.ok(cartService.calculateCart(productIds));

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}