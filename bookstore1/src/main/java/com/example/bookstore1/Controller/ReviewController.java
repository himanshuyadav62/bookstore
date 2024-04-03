package com.example.bookstore1.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore1.Entity.Book;
import com.example.bookstore1.Entity.Review;
import com.example.bookstore1.Repository.BookRepository;
import com.example.bookstore1.Repository.ReviewRepository;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ReviewController {
    private ReviewRepository reviewRepository;
    private BookRepository bookRepository;

    public ReviewController(ReviewRepository reviewRepository, BookRepository bookRepository) {
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
    }

    @PostMapping("/book/{bookId}/review")
    public ResponseEntity<String> addReviewtoBookEntity(@RequestBody Review review,@PathVariable Integer bookId) {
        
        if (review == null || bookId == null) {
            return ResponseEntity.ok("please add a review and book id");
        }
        Optional<Book> bookOptional = this.bookRepository.findById(bookId);
        if(!bookOptional.isPresent()) {
            return ResponseEntity.ok("Book not found");
        }
        try {
            Book book = bookOptional.get();
            review.setBook(book);
            this.reviewRepository.save(review);
            return ResponseEntity.ok("Review added successfully");
        } catch (Exception e) {
            return ResponseEntity.ok("Failed to add review " + e.getMessage());
        }
    }
}
