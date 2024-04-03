package com.example.bookstore1.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bookstore1.Entity.Book;
import com.example.bookstore1.Entity.Category;
import com.example.bookstore1.Repository.BookRepository;
import com.example.bookstore1.Repository.CategoryRepository;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private BookRepository bookRepository;

    public CategoryService(CategoryRepository categoryRepository, BookRepository bookRepository) {
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
    }

    public List<Category> getCategories() {
        return this.categoryRepository.findAll();
    }

    public ResponseEntity<String> addCategory(Category category) {
        if(category == null) {
            return ResponseEntity.ok("please add a category");
        }
          try {
            this.categoryRepository.save(category);
            return ResponseEntity.ok("Category added successfully");
        } catch (Exception e) {
            return ResponseEntity.ok("Failed to add category " + e.getMessage());
        }
    }

    public ResponseEntity<String> deleteCategory(Integer categoryId) {
        if(categoryId == null) {
            return ResponseEntity.ok("please provide category id");
        }
        try {
            this.categoryRepository.deleteById(categoryId);
            return ResponseEntity.ok("Category deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.ok("Failed to delete category");
        }
    }

    public Category getCategoryById(Integer categoryId) {
        if(categoryId == null) {
            return null;
        }
        return this.categoryRepository.findById(categoryId).get();
    }

    public ResponseEntity<String> addBookToCategory(Integer categoryId, Integer bookId) {
        if(categoryId == null || bookId == null) {
            return ResponseEntity.ok("please provide category id and book id");
        }
        Category category = this.categoryRepository.findById(categoryId).get();
        if(category == null) {
            return ResponseEntity.ok("Category not found");
        }
        Book book = this.bookRepository.findById(bookId).get();
        if(book == null) {
            return ResponseEntity.ok("Book not found");
        }
        try {
            List<Category> categories = book.getCategories();
            categories.add(category);
            book.setCategories(categories);
            this.bookRepository.save(book);
            return ResponseEntity.ok("Book added to category successfully");
        } catch (Exception e) {
            return ResponseEntity.ok("Failed to add book to category" + e.getMessage());
        }
    }
    
}
