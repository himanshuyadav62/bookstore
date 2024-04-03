package com.example.bookstore1.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Customer {
    
    @Id
    @GeneratedValue
    private Integer customerId;

    private String customerName;

    @Column(unique = true) 
    @NotEmpty(message = "Customer email is required")
    @Email(message = "Invalid email format")
    private String customerEmail;

    @Column(unique = true)
    private String customerPhone;

    private List<String> customerAddresses;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    private ShoppingCart shoppingCart;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    private Wishlist wishlist;

}
