package com.example.bookstore1.Entity;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Review {
    
    @Id
    @GeneratedValue
    private Integer reviewId;

    @Size(min = 10, max = 500)
    private String reviewContent;

    @Range(min = 1, max = 5)
    private Integer reviewRating;

    private Integer reviewCustomerId;

    @JsonIgnoreProperties("reviews")
    @ManyToOne
    private Book book;
}