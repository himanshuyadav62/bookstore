package com.example.bookstore1.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Category {
    
    @Id
    @GeneratedValue
    private Integer categoryId;

    @NotBlank(message = "Category name is required")
    private String categoryName;

    @Size(min = 20, max = 100, message = "Category description must be between 20 and 100 characters")
    private String categoryDescription;

    @JsonIgnoreProperties("categories")
    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Book> books;
}
