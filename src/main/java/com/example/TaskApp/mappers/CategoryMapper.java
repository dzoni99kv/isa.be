package com.example.TaskApp.mappers;

import com.example.TaskApp.entities.Category;
import com.example.TaskApp.models.CategoryModel;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {
    public static Category toEntity(CategoryModel model) {
        Category category = new Category();
        category.setId(model.getId());
        category.setName(model.getName());
        return category;
    }

    public static CategoryModel toModel(Category entity) {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(entity.getId());
        categoryModel.setName(entity.getName());
        return categoryModel;
    }

    public static List<CategoryModel> toModelList(List<Category> entities) {
        return entities.stream().map(CategoryMapper::toModel).collect(Collectors.toList());
    }
    public static List<Category> toEntityList(List<CategoryModel> models) {
        return models.stream()
                .map(CategoryMapper::toEntity)
                .collect(Collectors.toList());
    }

}
