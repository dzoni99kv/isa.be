package com.example.TaskApp.models;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ProductModel {
    private Integer id;
    @NotNull(message = "Product name cannot be null")
    private String name;
    @NotNull(message = "Product description cannot be null")
    private String description;
    @NotNull(message = "Product price cannot be null")
    private BigDecimal price;
    private List<CategoryModel> categories;
}
