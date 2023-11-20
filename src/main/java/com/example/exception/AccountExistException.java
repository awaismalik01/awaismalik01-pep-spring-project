package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AccountExistException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AccountExistException(String msg){
        super(msg);
    }
}
