package com.example.bookStore.web.conrollers;

import com.example.bookStore.dto.AuthorDto;
import com.example.bookStore.dto.BookDto;
import com.example.bookStore.model.entities.Response;
import com.example.bookStore.service.AuthorService;
import com.example.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<Response<List<AuthorDto>>> getAllAuthors(){
        List<AuthorDto> authorDtos = this.authorService.getAuthors();
        Response<List<AuthorDto>> response = new Response<>(200, "success",
                "Authors  retrieved successfully",
                authorDtos);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/author")
    public ResponseEntity<Response<AuthorDto>> getAuthorById(@RequestParam Integer id){
        AuthorDto authorDto = this.authorService.getAuthorById(id);
        Response<AuthorDto> response = new Response<>(200, "success",
                "Author retrieved successfully",
                authorDto);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/add-author")
    public ResponseEntity<Response<AuthorDto>> addAuthor(@RequestBody AuthorDto authorDto){
        AuthorDto addedAuthor = this.authorService.addAuthor(authorDto);
        Response<AuthorDto> response = new Response<>(201, "success",
                "Author added successfully", addedAuthor);
        return ResponseEntity.status(201).body(response);

//        if(addedAuthor != null){
//            Response<AuthorDto> response = new Response<>(201, "success",
//                    "Author added successfully", addedAuthor);
//            return ResponseEntity.status(201).body(response);
//        }else{
//            Response<AuthorDto> response = new Response<>(400, "error",
//                    "Failed to add Author", null);
//            return ResponseEntity.status(400).body(response);
//        }
    }
    @DeleteMapping("/delete-author/{id}")
    public ResponseEntity<Response<Boolean>> deleteBookById(@PathVariable Integer id) {
        boolean deleted = authorService.deleteById(id);
        Response<Boolean> response = new Response<>(204, "success",
                "Author deleted successfully",
                null);
        return ResponseEntity.status(204).body(response);
//        if (deleted) {
//            Response<Void> response = new Response<>(204, "success",
//                    "Book deleted successfully",
//                    null);
//            return ResponseEntity.status(204).body(response);
//        } else {
//            Response<Void> response = new Response<>(404, "error",
//                    "Book not found",
//                    null);
//            return ResponseEntity.status(404).body(response);
//        }
    }
}
