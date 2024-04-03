package com.example.bookstore1.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItem {
    
    @Id
    @GeneratedValue
    private Integer orderItemId;

    private int quantity;

    private Integer ordreredBookId; // bookId

    @ManyToOne
    private Order order;


}
