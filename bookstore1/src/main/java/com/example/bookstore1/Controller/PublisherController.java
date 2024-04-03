package com.example.bookstore1.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore1.Entity.Publisher;
import com.example.bookstore1.Repository.PublisherRepository;

@RestController
public class PublisherController {
    private PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @GetMapping("/publishers")
    public List<Publisher> getMethodName() {
        return publisherRepository.findAll();
    }

    @PostMapping("/publisher")
    public ResponseEntity<String> addPublisher(@RequestBody Publisher publisher) {
        if (publisher == null) {
            return ResponseEntity.ok("please add a publisher");
        }
        try {
            this.publisherRepository.save(publisher);
            return ResponseEntity.ok("Publisher added successfully");
        } catch (Exception e) {
            return ResponseEntity.ok("Failed to add publisher " + e.getMessage());
        }
    }

    @GetMapping("/publisher/{publisherId}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Integer publisherId) {
        if (publisherId == null) {
            return new ResponseEntity<>(new Publisher(), HttpStatus.BAD_REQUEST);
        }
        Optional<Publisher> publisher = this.publisherRepository.findById(publisherId);
        if (publisher.isPresent()) {
            return ResponseEntity.ok(publisher.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
