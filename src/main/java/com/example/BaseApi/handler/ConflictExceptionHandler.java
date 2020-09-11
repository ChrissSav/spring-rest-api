package com.example.BaseApi.handler;

import com.example.BaseApi.exceptions.ConflictException;
import com.example.BaseApi.exceptions.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ConflictExceptionHandler {

    @ExceptionHandler(value = {ConflictException.class})
    public ResponseEntity<Object> handleApiException(ConflictException conflictException) {
        return new ResponseEntity<>(new ErrorResponse(conflictException), HttpStatus.CONFLICT);
    }
}


