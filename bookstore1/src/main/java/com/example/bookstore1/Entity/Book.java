package com.example.bookstore1.Entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Integer bookId;

    @NotBlank(message = "Book title is required")
    @Size(min = 2, max = 100, message = "Book title must be between 3 and 100 characters")
    private String bookTitle;

    @Size(min = 20, max = 100, message = "Book description must be between 20 and 100 characters")
    private String bookDescription;

    @Column(unique = true)
    private String bookIsbn;

   

    private Date bookPublishedDate;

    private int bookPrice;

    private int bookStock;

    private Date bookUpdatedAt;

    private Date bookDeletedAt;

    @JsonIgnoreProperties("books")
    @ManyToMany
    @JoinTable(
        name = "book_language",
        joinColumns = @JoinColumn(name = "bookId"),
        inverseJoinColumns = @JoinColumn(name = "languageId")
    )
    private List<Language> bookLanguages;

    @JsonIgnoreProperties("books")
    @ManyToMany
    @JoinTable(
        name = "book_author",
        joinColumns = @JoinColumn(name = "bookId"),
        inverseJoinColumns = @JoinColumn(name = "authorId")
    )
    private List<Author> authors;
    
    @JsonIgnoreProperties("books")
    @ManyToMany
    @JoinTable(
        name = "book_category",
        joinColumns = @JoinColumn(name = "bookId"),
        inverseJoinColumns = @JoinColumn(name = "categoryId")
    )
    private List<Category> categories;

    @JsonIgnoreProperties("book")
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @JsonIgnoreProperties("books")
    @ManyToOne
    private Publisher publisher;
}
