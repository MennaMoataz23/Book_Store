package com.example.bookStore.repository;

import com.example.bookStore.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book>findByPriceBetween(double start, double end);
    List<Book>findByAuthor(String author);
    Book findByTitle(String title);
}

//join
//unit test
//validation
//flyway
