package com.example.TaskApp.mappers;

import com.example.TaskApp.entities.Product;
import com.example.TaskApp.models.ProductModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ProductMapper {
    public static Product toEntity(ProductModel model) {
        Product product = new Product();
        product.setId(model.getId());
        product.setName(model.getName());
        product.setDescription(model.getDescription());
        product.setPrice(model.getPrice());
        product.setCategories(CategoryMapper.toEntityList(model.getCategories())); // Assuming a category mapper
        return product;
    }

    public static ProductModel toModel(Product entity) {
        return ProductModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .categories(CategoryMapper.toModelList(entity.getCategories()))
                .build();
    }

    public static List<ProductModel> toModelList(List<Product> entities) {
        return entities.stream().map(ProductMapper::toModel).collect(Collectors.toList());
    }
}
