package com.example.bookstore1.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.bookstore1.Entity.Author;
import com.example.bookstore1.Entity.Book;
import com.example.bookstore1.Entity.Publisher;
import com.example.bookstore1.Repository.AuthorRepository;
import com.example.bookstore1.Repository.BookRepository;
import com.example.bookstore1.Repository.PublisherRepository;

@Service
public class BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    public Book getBookById(Integer bookId) {
        if(bookId == null) {
            return null;
        }
        Optional<Book> book = this.bookRepository.findById(bookId);
        if (book.isPresent()) {
            return book.get();
        }
        return null;
    }

    public String addBook(Book book) {
        if(book == null) {
            return "please add a book";
        }
        try {
            Date date = new Date();
            // setting data to current data
            book.setBookPublishedDate(date);
            this.bookRepository.save(book);
            return "Book added successfully";
        } catch (Exception e) {
            return "Failed to add book";
        }
    }

    public String updateBook(Integer bookId, Book book) {
        if(bookId == null || book == null) {
            return "please provide book id and book details";
        }
        Optional<Book> bookOptional = this.bookRepository.findById(bookId);
        if (bookOptional.isPresent()) {
            try {
                this.bookRepository.save(book);
                return "Book updated successfully";
            } catch (Exception e) {
                return "Failed to update book";
            }
        }
        return "Book not found";
    }

    public String deleteBook(Integer bookId) {
        if(bookId == null) {
            return "please provide book id";
        }
        Optional<Book> bookOptional = this.bookRepository.findById(bookId);
        if (bookOptional.isPresent()) {
            try {
                this.bookRepository.deleteById(bookId);
                return "Book deleted successfully";
            } catch (Exception e) {
                return "Failed to delete book";
            }
        }
        return "Book not found";
    }

    public String addAuthorToBook(Integer bookId, Integer authorId) {
        if(bookId == null || authorId == null) {
            return "please provide book id and author id";
        }
        Optional<Book> bookOptional = this.bookRepository.findById(bookId);
        if (!bookOptional.isPresent()) {
            return "Book not found";
        }
        Optional<Author> authorOptional = this.authorRepository.findById(authorId);
        if (!authorOptional.isPresent()) {
            return "Author not found";
        }
        Book book = bookOptional.get();
        Author author = authorOptional.get();
        List<Author> authors = book.getAuthors();
        authors.add(author);
        book.setAuthors(authors);
        try {
            this.bookRepository.save(book);
            return "Author added to book successfully";
        } catch (Exception e) {
            return "Failed to add author to book";
        }
    }

    public String addPublisherToBook(Integer bookId, Integer publisherId) {
        if(bookId == null || publisherId == null) {
            return "please provide book id and publisher id";
        }
        Optional<Book> bookOptional = this.bookRepository.findById(bookId);
        if (!bookOptional.isPresent()) {
            return "Book not found";
        }
        Optional<Publisher> publisherOptional = this.publisherRepository.findById(publisherId);
        if (!publisherOptional.isPresent()) {
            return "Publisher not found";
        }
        Book book = bookOptional.get();
        Publisher publisher = publisherOptional.get();
        book.setPublisher(publisher);
        try {
            this.bookRepository.save(book);
            return "Publisher added to book successfully";
        } catch (Exception e) {
            return "Failed to add publisher to book";
        }
    }

}
