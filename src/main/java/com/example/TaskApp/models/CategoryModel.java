package com.example.TaskApp.models;


import lombok.Data;

import java.util.Set;

@Data
public class CategoryModel {
    private Integer id;
    private String name;
    private Set<ProductModel> products;}
