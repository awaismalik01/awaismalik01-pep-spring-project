package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MessageUpdateException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MessageUpdateException(String msg) {
        super(msg);
    }
}
