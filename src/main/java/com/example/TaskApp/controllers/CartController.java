package com.example.TaskApp.controllers;

import com.example.TaskApp.models.CartItemModel;
import com.example.TaskApp.models.CartModel;
import com.example.TaskApp.models.ProductModel;
import com.example.TaskApp.services.CartService;
import com.example.TaskApp.services.ICartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
    private final ICartService cartService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CartModel create(@RequestBody @Valid CartModel cartModel) {
        System.out.println("Incoming CartModel: " + cartModel); // Log the incoming model
        return cartService.create(cartModel);
    }

    @GetMapping("/{cartId}/items")
    public ResponseEntity<?> getCartItems(@PathVariable @Valid Integer cartId) {
        List<CartItemModel> items = cartService.getCartItems(cartId);
        return ResponseEntity.ok(items);
    }

    @DeleteMapping("/remove/{cartId}")
    public ResponseEntity<Void> removeCart(@PathVariable Integer cartId) {
        cartService.removeCart(cartId);
        return ResponseEntity.noContent().build();
    }
    }
    /*
    * @DeleteMapping("/delete/{id}") // Using PathVariable for better REST practice
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productService.delete(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
    * */
