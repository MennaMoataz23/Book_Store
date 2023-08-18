package com.example.bookStore.service;

import com.example.bookStore.dto.AuthorDto;
import com.example.bookStore.dto.BookDto;
import com.example.bookStore.exception.NotFoundException;
import com.example.bookStore.model.entities.Book;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAuthors();
    AuthorDto getAuthorById(Integer id) throws NotFoundException;
    AuthorDto addAuthor(AuthorDto authorDto);
    void updateAuthor(Integer id, AuthorDto authorDto);
    boolean deleteById(Integer id);
//    List<Book> findBooksByAuthor(String author);
}
