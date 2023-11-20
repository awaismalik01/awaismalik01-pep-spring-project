package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MessageInvalidException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MessageInvalidException(String msg) {
        super(msg);
    }
}
