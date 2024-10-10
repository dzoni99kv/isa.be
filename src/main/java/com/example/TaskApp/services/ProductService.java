package com.example.TaskApp.services;

import com.example.TaskApp.exceptions.product.ProductException;
import com.example.TaskApp.mappers.ProductMapper;
import com.example.TaskApp.models.ProductModel;
import com.example.TaskApp.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    @Override
    public List<ProductModel> findAll() {
        var products = productRepository.findAll();
        return ProductMapper.toModelList(products);
    }

    @Override
    public ProductModel create(ProductModel model) {
        var product = ProductMapper.toEntity(model);
        var savedProduct = productRepository.save(product);
        return ProductMapper.toModel(savedProduct);
    }

    @Override
    public ProductModel update(ProductModel model) {
        var product = ProductMapper.toEntity(model);
        var updatedProduct = productRepository.save(product);
        return ProductMapper.toModel(updatedProduct);
    }

    @Override
    public void delete(Integer productId) {
        var product = productRepository.findById(productId);
        if (product.isPresent()) {
            productRepository.delete(product.get());
        } else {
            throw new ProductException("Product Not Found");
        }
    }

    @Override
    public Optional<ProductModel> findById(Integer productId) {
        return productRepository.findById(productId).map(ProductMapper::toModel);
    }
}

