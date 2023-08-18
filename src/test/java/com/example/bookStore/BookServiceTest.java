//package com.example.bookStore;
//
//import static org.mockito.Mockito.*;
//
//import com.example.bookStore.dto.BookDto;
//import com.example.bookStore.exception.NotFoundException;
//import com.example.bookStore.mapper.BookMapper;
//import com.example.bookStore.model.entities.Book;
//import com.example.bookStore.repository.BookRepository;
//import com.example.bookStore.service.implementation.BookServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.Cache;
//import org.springframework.cache.CacheManager;
//
//import java.util.Optional;
//
//class BookServiceTest {
//    @Mock
//    private BookRepository bookRepository;
//    @Mock
//    private CacheManager cacheManager;
//    @Autowired
//    private BookServiceImpl bookService;
//    private BookMapper bookMapper;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        bookService = new BookServiceImpl(bookRepository, bookMapper); // Replace null with your BookMapper instance
//        when(cacheManager.getCache("books")).thenReturn(mock(Cache.class));
//        bookService.setCacheManager(cacheManager);
//    }
//
//    @Test
//    void testGetBookById_CacheBehavior() throws NotFoundException {
//        // Arrange
//        int bookId = 1;
//        Book book = new Book();
//        book.setId(bookId);
//        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));
//
//        // Act
//        BookDto firstCallResult = bookService.getBookById(bookId);
//        BookDto secondCallResult = bookService.getBookById(bookId);
//
//        // Assert
//        verify(bookRepository, times(1)).findById(bookId); // Should be queried once only
//        verify(cacheManager.getCache("books"), times(1)).put(bookId, firstCallResult); // Cache should be populated
//
//        // Subsequent calls should not query the repository again
//        BookDto cachedResult = bookService.getBookById(bookId);
//        verifyNoMoreInteractions(bookRepository);
//        verify(cacheManager.getCache("books"), times(1)).get(bookId); // Should be retrieved from cache
//    }
//}
