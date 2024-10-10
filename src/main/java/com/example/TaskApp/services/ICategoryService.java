package com.example.TaskApp.services;

import com.example.TaskApp.models.CategoryModel;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<CategoryModel> findAll();
    CategoryModel create(CategoryModel category);
    CategoryModel update(CategoryModel category);
    void delete(Integer categoryId);
    Optional<CategoryModel> findById(Integer categoryId);
}

