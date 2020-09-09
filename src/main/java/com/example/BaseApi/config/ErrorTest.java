package com.example.BaseApi.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ErrorTest {

    @ExceptionHandler(value = {ApiException.class})
    public ResponseEntity<Object> handleApiException(ApiException ex) {
        ErrorResponse test = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(test, HttpStatus.BAD_REQUEST);

    }
}


