package com.example.TaskApp.controllers;

import com.example.TaskApp.entities.Product;
import com.example.TaskApp.models.ProductModel;
import com.example.TaskApp.repositories.IProductRepository;
import com.example.TaskApp.services.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    private final IProductService productService;

    @GetMapping("/get-list")
    public List<ProductModel> getList() {
        return productService.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED) // Indicates the resource was created
    public ProductModel create(@RequestBody @Valid ProductModel productModel) {
        return productService.create(productModel);
    }

    @PutMapping("/update/{id}") // Using PathVariable for better REST practice
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Valid ProductModel productModel, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        productModel.setId(id); // Ensure the ID is set for the update
        return ResponseEntity.ok(productService.update(productModel));
    }

    @DeleteMapping("/delete/{id}") // Using PathVariable for better REST practice
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productService.delete(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}

