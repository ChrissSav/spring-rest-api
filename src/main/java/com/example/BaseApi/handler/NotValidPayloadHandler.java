package com.example.BaseApi.handler;

import com.example.BaseApi.exceptions.ErrorResponse;
import com.example.BaseApi.exceptions.ExceptionCodes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotValidPayloadHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(new ErrorResponse(ExceptionCodes.NOT_VALID_PAYLOAD), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
