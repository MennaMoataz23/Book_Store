package com.example.bookStore.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.core.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

//@RestControllerAdvice
//public class ApplicationExceptionHandler {
//    @ExceptionHandler(BookNotFoundException.class)
//    public ResponseEntity<Object>
//}

//response model => error discription, body