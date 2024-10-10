package com.example.TaskApp.models;

import lombok.Data;

@Data
public class CartItemModel {
    private Integer id;
    private Integer quantity;
    private ProductModel product; // Adjust this according to your ProductModel
}
