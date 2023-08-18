package com.example.bookStore.web.conrollers;

import com.example.bookStore.dto.BookDto;
import com.example.bookStore.model.entities.Response;
import com.example.bookStore.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping("/books")
    public ResponseEntity<Response<List<BookDto>>> getAllBooks(){
        List<BookDto> bookDtos = this.bookService.getBooks();
        Response<List<BookDto>> response = new Response<>(200, "success",
        "Books  retrieved successfully",
                bookDtos);
        logger.trace("GetBook method has been accessed");
        return ResponseEntity.ok(response);
    }
    @GetMapping("/book")
    public ResponseEntity<Response<BookDto>> getBookById(@RequestParam Integer id){
        BookDto bookDto = this.bookService.getBookById(id);
        Response<BookDto> response = new Response<>(200, "success",
                "Book retrieved successfully",
                        bookDto);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/add-book")
    public ResponseEntity<Response<BookDto>> addBook(@RequestBody BookDto bookdto){
        BookDto addedBook = this.bookService.addBook(bookdto);
        if(addedBook != null){
            Response<BookDto> response = new Response<>(201, "success",
                    "Book added successfully", addedBook);
            return ResponseEntity.status(201).body(response);
        }else{
            Response<BookDto> response = new Response<>(400, "error",
                    "Failed to add book", null);
            return ResponseEntity.status(400).body(response);
        }
    }
    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<Response<Void>> deleteBookById(@PathVariable Integer id) {
        boolean deleted = bookService.deleteById(id);

        if (deleted) {
            Response<Void> response = new Response<>(204, "success",
                    "Book deleted successfully",
                    null);
            return ResponseEntity.status(204).body(response);
        } else {
            Response<Void> response = new Response<>(404, "error",
                    "Book not found",
                    null);
            return ResponseEntity.status(404).body(response);
        }
    }
    @PutMapping("/update-book/{id}")
    public ResponseEntity<Response<BookDto>> updateBook(@PathVariable Integer id,
                                                        @RequestBody BookDto bookDto){
        bookService.updateBook(id, bookDto);
        Response<BookDto> response = new Response<>(200, "success",
                "Book updated successfully", bookDto);
        return ResponseEntity.status(200).body(response);
    }
//    @GetMapping("/books/byAuthor")
//    public List<BookDto> getBooksByAuthor(@RequestParam("author") String author){
//        return this.bookService.findBooksByAuthor(author);
//    }

    @GetMapping("/books/byTitle")
    public BookDto getBookByTitle(@RequestParam("title") String title){
        return this.bookService.findBookByTitle(title);
    }
}
