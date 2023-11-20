package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class AccountCredentialsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AccountCredentialsException(String msg) {
        super(msg);
    }
}
