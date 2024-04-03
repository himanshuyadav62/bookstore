package com.example.bookstore1.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue
    private Integer authorId;

    private String authorName;

    @NotEmpty(message = "Author email is required")
    @Email(message = "Invalid email format")
    @Column(unique = true)
    private String authorEmail;

    private String authorBio;

    @JsonIgnoreProperties("authors")
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
}
