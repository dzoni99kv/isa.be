package com.example.TaskApp.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CartModel {
    private Integer id; // Optional for creation
    private LocalDateTime createdAt = LocalDateTime.now();
    private UserModel user; // Ensure this has the correct UserModel structure
}

