package com.example.bookstore1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore1.Entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer>{

} 
