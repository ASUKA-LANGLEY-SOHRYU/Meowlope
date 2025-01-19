package com.prosvirnin.authservice.exception.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserNotFoundException extends ApiException {
    public UserNotFoundException(String username) {
        super("User with username: " + username + " does not exist.");
    }
}
