package com.example.TaskApp.services;

import com.example.TaskApp.exceptions.category.CategoryException;
import com.example.TaskApp.mappers.CategoryMapper;
import com.example.TaskApp.models.CategoryModel;
import com.example.TaskApp.repositories.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;

    @Override
    public List<CategoryModel> findAll() {
        var categories = categoryRepository.findAll();
        return CategoryMapper.toModelList(categories);
    }

    @Override
    public CategoryModel create(CategoryModel model) {
        var category = CategoryMapper.toEntity(model);
        var savedCategory = categoryRepository.save(category);
        return CategoryMapper.toModel(savedCategory);
    }

    @Override
    public CategoryModel update(CategoryModel model) {
        var category = CategoryMapper.toEntity(model);
        var updatedCategory = categoryRepository.save(category);
        return CategoryMapper.toModel(updatedCategory);
    }

    @Override
    public void delete(Integer categoryId) {
        var category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            categoryRepository.delete(category.get());
        } else {
            throw new CategoryException("Category Not Found");
        }
    }

    @Override
    public Optional<CategoryModel> findById(Integer categoryId) {
        return categoryRepository.findById(categoryId).map(CategoryMapper::toModel);
    }
}

