package com.ntnghia.nghianguyenblog.service;

import com.ntnghia.nghianguyenblog.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();

    Category findById(int id);

    List<Category> findByNameContains(String name);

    Category saveCategory(Category category);

    Category updateCategory(int id, Category category);

    void deleteCategory(int id);
}
