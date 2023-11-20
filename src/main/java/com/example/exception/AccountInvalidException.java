package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AccountInvalidException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AccountInvalidException(String msg){
        super(msg);
    }
}
