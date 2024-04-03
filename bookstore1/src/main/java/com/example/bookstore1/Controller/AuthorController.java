package com.example.bookstore1.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore1.Entity.Author;
import com.example.bookstore1.Repository.AuthorRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthorController {
     private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public List<Author> getMethodName() {
        return authorRepository.findAll();
    }

    @PostMapping("/author")
    public ResponseEntity<String> addAuthoResponseEntity(@RequestBody Author author) {
        if(author == null) {
            return ResponseEntity.ok("please add an author");
        }
        try {
            this.authorRepository.save(author);
            return ResponseEntity.ok("Author added successfully");
        } catch (Exception e) {
            return ResponseEntity.ok("Failed to add author");
        }
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<Author> getAuthorByIdResponseEntity(@PathVariable Integer authorId) {
        if(authorId == null) {
            return ResponseEntity.ok(null);
        }
        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            return ResponseEntity.ok(author.get());
        }
        return ResponseEntity.ok(null);
    }
    
}
