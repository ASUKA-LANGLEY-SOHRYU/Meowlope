package com.prosvirnin.authservice.controller;

import com.prosvirnin.authservice.exception.api.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = ApiException.class)
    public ProblemDetail handleApiException(ApiException exception) {
        HttpStatus httpStatus = exception.getClass().getAnnotation(ResponseStatus.class).code();
        return ProblemDetail.forStatusAndDetail(httpStatus, exception.getMessage());
    }
}
