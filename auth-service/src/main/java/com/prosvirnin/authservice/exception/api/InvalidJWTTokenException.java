package com.prosvirnin.authservice.exception.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidJWTTokenException extends ApiException {
    public InvalidJWTTokenException() {
        super("Invalid jwt token.");
    }
}
