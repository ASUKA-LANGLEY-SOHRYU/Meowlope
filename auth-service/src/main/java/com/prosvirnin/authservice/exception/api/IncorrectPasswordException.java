package com.prosvirnin.authservice.exception.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IncorrectPasswordException extends ApiException {
    public IncorrectPasswordException() {
        super("Incorrect password.");
    }
}
