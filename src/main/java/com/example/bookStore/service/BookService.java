package com.example.bookStore.service;

import com.example.bookStore.dto.BookDto;
import com.example.bookStore.exception.NotFoundException;
import com.example.bookStore.model.entities.Book;

import java.util.List;

public interface BookService {
    List<BookDto> getBooks();
    BookDto getBookById(Integer id) throws NotFoundException;
    BookDto addBook(BookDto bookDto);
    void updateBook(Integer id,BookDto bookDto);
    boolean deleteById(Integer id);
    BookDto findBookByTitle(String title);
    List<Book> findBooksByAuthor(String author);
}
