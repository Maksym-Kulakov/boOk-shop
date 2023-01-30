package com.shop.book.exception;

import org.springframework.http.HttpStatus;

public class BookException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public BookException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public BookException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }
}
