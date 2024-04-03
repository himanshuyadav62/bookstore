package com.example.bookstore1.Controller;

import java.util.List;
import com.example.bookstore1.Entity.Book;
import com.example.bookstore1.service.BookService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class BookController {

   
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String home(){
        return "Welcome to the Book Store";
    }
    @GetMapping("/books")
    public List<Book> getMethodName() {
        return bookService.getAllBooks();
    }
    
    @GetMapping("/book/{bookId}")
    public ResponseEntity<Book> getBookByIdEntity(@PathVariable Integer bookId) {
        return new ResponseEntity<>(this.bookService.getBookById(bookId), HttpStatus.OK);
    }
    
    @PostMapping("/book")
    public ResponseEntity<String> addBookEntity( @RequestBody Book book) {
        return new ResponseEntity<>(this.bookService.addBook(book), HttpStatus.CREATED);
    }
    
    // updata a book 
    @PutMapping("book/{bookId}")
    public ResponseEntity<String> updateBooEntity(@PathVariable Integer bookId, @RequestBody Book book) {
        return new ResponseEntity<>(this.bookService.updateBook(bookId, book), HttpStatus.OK);
    }

    @DeleteMapping("book/{bookId}")
    public ResponseEntity<String> deleteBookEntity(@PathVariable Integer bookId) {
        return new ResponseEntity<>(this.bookService.deleteBook(bookId), HttpStatus.OK);
    }

    @PostMapping("/book/{bookId}/author/{authorId}")
    public ResponseEntity<String> addAuthorToBookEntity(@PathVariable Integer bookId, @PathVariable Integer authorId) {
        return new ResponseEntity<>(this.bookService.addAuthorToBook(bookId, authorId), HttpStatus.OK);
    }
    

    // add publisher to book 
    @PutMapping("book/{bookId}/publisher/{publisherId}")
    public ResponseEntity<String> putMethodName(@PathVariable Integer bookId, @PathVariable Integer publisherId) {
        return new ResponseEntity<>(this.bookService.addPublisherToBook(bookId, publisherId), HttpStatus.OK);
    }
}
