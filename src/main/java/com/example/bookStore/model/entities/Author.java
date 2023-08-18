package com.example.bookStore.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phoneNumber", nullable = false)
    private Long phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(targetEntity = Book.class)
    @JoinColumn(name = "ab_fk", referencedColumnName = "id")
    private List<Book> books;
}