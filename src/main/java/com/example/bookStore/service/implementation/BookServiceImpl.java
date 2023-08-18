package com.example.bookStore.service.implementation;

import com.example.bookStore.dto.BookDto;
import com.example.bookStore.exception.BadEntryException;
import com.example.bookStore.exception.NotFoundException;
import com.example.bookStore.mapper.BookMapper;
import com.example.bookStore.model.constants.enums.Error;
import com.example.bookStore.model.entities.Book;
import com.example.bookStore.repository.BookRepository;
//import com.example.bookStore.validations.BookValidation;
import com.example.bookStore.service.BookService;
import com.example.bookStore.web.conrollers.BookController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;
    Logger logger = LoggerFactory.getLogger(BookController.class);


//    @Autowired
//    private BookValidation bookValidation;

    @Override
    @Cacheable("books")
    public List<BookDto> getBooks() {
        logger.info("fetching books from db");
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        books.forEach(book -> bookDtos.add(bookMapper.entityToDto(book)));
        return bookDtos;
    }

    @Override
    @Cacheable(value = "books", key = "id")
    public BookDto getBookById(Integer id) throws NotFoundException {
        logger.info("fetching book from db");
        Optional<Book> book = this.bookRepository.findById(id);
        if (book.isPresent()){
            return bookMapper.entityToDto(book.get());
        }
        else {
            logger.error("Book not found!");
            throw new NotFoundException(Error.NOTFOUND_ERROR.getMessage());
        }
    }
    @Override
    @CachePut(value = "books", key = "#result.id")
    public BookDto addBook(BookDto bookDto) {
        Book savedBook = this.bookRepository.save(Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .description(bookDto.getDescription())
                .price(bookDto.getPrice()).build());
        return BookDto.builder().title(savedBook.getTitle())
                .author(savedBook.getAuthor())
                .description(savedBook.getDescription())
                .price(savedBook.getPrice())
                .id(savedBook.getId()).build();
    }

    @CacheEvict(value = "books", key = "#id")
    @CachePut(value = "books", key = "#result.id")
    public void updateBook(Integer id, BookDto bookDto)
    {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            bookMapper.updateBookFromBookDto(bookDto, existingBook);
            bookRepository.save(existingBook);
        } else {
            throw new NotFoundException(Error.NOTFOUND_ERROR.getMessage());
        }
    }
    @CacheEvict(value = "books", key = "#id")
    public boolean deleteById(Integer id)
    {
        bookRepository.deleteById(id);
        return true;
    }
    @Cacheable(value = "books", key = "#title")
    public BookDto findBookByTitle(String title)
    {
        Book book = bookRepository.findByTitle(title);
        return bookMapper.entityToDto(book);
    }
    @Cacheable(value = "books", key = "#author")
    public List<Book> findBooksByAuthor(String author)
    {
        List<Book> book = bookRepository.findByAuthor(author);
        return book;
    }
}
