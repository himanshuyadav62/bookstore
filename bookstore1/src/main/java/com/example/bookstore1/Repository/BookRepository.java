package com.example.bookstore1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore1.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    
}
