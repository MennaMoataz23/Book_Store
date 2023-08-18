package com.example.bookStore.model.constants.enums;

import lombok.Getter;

@Getter
public enum Error {
    NOTFOUND_ERROR("Book Not Foound"),
    BADREQUEST_ERROR("Check your request and try again");

    private Integer statusCode;
    private String status;
    private String message;

    Error(String message) {
//        this.statusCode = errorCode;
//        this.status = status;
        this.message = message;
    }
}
