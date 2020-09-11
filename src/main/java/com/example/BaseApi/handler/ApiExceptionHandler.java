package com.example.BaseApi.handler;

import com.example.BaseApi.exceptions.ApiException;
import com.example.BaseApi.exceptions.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiException.class})
    public ResponseEntity<Object> handleApiException(ApiException apiException) {
        return new ResponseEntity<>(new ErrorResponse(apiException), HttpStatus.BAD_REQUEST);
    }
}


