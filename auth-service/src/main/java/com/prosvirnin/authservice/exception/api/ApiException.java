package com.prosvirnin.authservice.exception.api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public abstract class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
