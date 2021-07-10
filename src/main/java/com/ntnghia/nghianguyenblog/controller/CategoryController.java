package com.ntnghia.nghianguyenblog.controller;

import com.ntnghia.nghianguyenblog.entity.Category;
import com.ntnghia.nghianguyenblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/blog/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable int id) {
        return categoryService.findById(id);
    }

    @GetMapping("/search")
    public List<Category> getByName(@RequestParam String name) {
        return categoryService.findByNameContains(name);
    }

    @PostMapping()
    public Category post(@Valid @RequestBody Category task) {
        return categoryService.saveCategory(task);
    }

    @PutMapping("/{id}")
    public Category put(@PathVariable int id, @Valid @RequestBody Category task) {
        return categoryService.updateCategory(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }

}
