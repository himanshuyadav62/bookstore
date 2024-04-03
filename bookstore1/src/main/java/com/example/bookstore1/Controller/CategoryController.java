package com.example.bookstore1.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore1.Entity.Category;
import com.example.bookstore1.service.CategoryService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return this.categoryService.getCategories();
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Category> getCatEntity(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(this.categoryService.getCategoryById(categoryId));
    }

    @PostMapping("/category")
    public ResponseEntity<String> addCategorEntity(@RequestBody Category category) {
        return this.categoryService.addCategory(category);
    }

    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<String> deleteCategoryEntity(@RequestBody Integer categoryId) {
        return this.categoryService.deleteCategory(categoryId);
    }

    // add book to category 
    @PutMapping("category/{categoryId}/book/{bookId}")
    public ResponseEntity<String> putMethodName( @PathVariable Integer categoryId, @PathVariable Integer bookId) {
        return this.categoryService.addBookToCategory(categoryId, bookId);
    }
}
