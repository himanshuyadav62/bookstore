package com.example.bookstore1.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Publisher {
    
    @Id 
    @GeneratedValue
    private Integer publisherId;

    @NotBlank
    private String publisherName;

    private String publisherAddress;

    private String publisherPhone;

    private String publisherEmail;

    private String publisherWebsite;

    @JsonIgnoreProperties("publisher")
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<Book> books;

}
