package com.prosvirnin.authservice.exception.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserAlreadyExistsException extends ApiException {
    public UserAlreadyExistsException(String username) {
        super("User with username: " + username + " already exists.");
    }
}
