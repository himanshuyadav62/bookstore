package com.example.bookstore1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore1.Entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
    
}
