package com.example.bookStore.validations;

import com.example.bookStore.dto.BookDto;
import com.example.bookStore.exception.NotFoundException;
import com.example.bookStore.model.entities.Book;
import com.example.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.bookStore.model.constants.enums.Error;


import java.util.Optional;

//public class BookValidationImpl implements BookValidation{
//    private BookDto bookDto;
//    @Override
//    public boolean bookExists(Integer id) {
//        BookDto book = bookDto.getId(id);
//        if (book == null){
//            throw new NotFoundException(Error.NOTFOUND_ERROR.getMessage());
//        }
//        return true;
//    }
//
//}
