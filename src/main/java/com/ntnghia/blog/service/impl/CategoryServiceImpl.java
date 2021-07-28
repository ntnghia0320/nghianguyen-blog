package com.ntnghia.blog.service.impl;

import com.ntnghia.blog.entity.Category;
import com.ntnghia.blog.repository.CategoryRepository;
import com.ntnghia.blog.service.CategoryService;
import com.ntnghia.blog.exception.BadRequestException;
import com.ntnghia.blog.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        if (isIdExist(id)) return categoryRepository.findById(id).get();

        throw new NotFoundException(String.format("Category id %d not found", id));
    }

    @Override
    public List<Category> findByNameContains(String name) {
        return categoryRepository.findByNameContains(name);
    }

    @Override
    public Category saveCategory(Category category) {
        if (!isCategoryNameExist(category.getName())) return categoryRepository.save(category);

        throw new BadRequestException("Category name exist");
    }

    @Override
    public Category updateCategory(int id, Category category) {
        if (isIdExist(id)) {
            Category categoryOld = categoryRepository.findById(id).get();

            if (categoryOld.getName().equals(category.getName())) {
                throw new BadRequestException("Category not change");
            } else if (isCategoryNameExist(category.getName())) {
                throw new BadRequestException("Category duplicate");
            } else {
                category.setId(id);

                return categoryRepository.save(category);
            }
        }

        throw new NotFoundException(String.format("Category id %d not found", id));
    }

    @Override
    public void deleteCategory(int id) {
        if (isIdExist(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new NotFoundException(String.format("Category id %d not found", id));
        }
    }

    private boolean isCategoryNameExist(String name) {
        return categoryRepository.findOneByName(name) != null;
    }

    private boolean isIdExist(int id) {
        return categoryRepository.existsById(id);
    }
}
