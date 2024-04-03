package com.example.bookstore1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore1.Entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{
    
}
