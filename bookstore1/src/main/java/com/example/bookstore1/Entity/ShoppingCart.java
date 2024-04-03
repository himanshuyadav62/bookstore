package com.example.bookstore1.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShoppingCart {
    
    @Id
    @GeneratedValue
    private Integer shoppingCartId;

    List<Integer> cartBookIds;

    @OneToOne
    private Customer customer;
}
