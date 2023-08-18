package com.example.bookStore.model.entities;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "description")
    private String description;
    @Column(name = "price", nullable = false)
    private double price;
    public Book(String title, String author, String description, double price) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
    }
}
