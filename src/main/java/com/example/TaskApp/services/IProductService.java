package com.example.TaskApp.services;

import com.example.TaskApp.models.ProductModel;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<ProductModel> findAll();
    ProductModel create(ProductModel product);
    ProductModel update(ProductModel product);
    void delete(Integer productId);
    Optional<ProductModel> findById(Integer productId);
}
