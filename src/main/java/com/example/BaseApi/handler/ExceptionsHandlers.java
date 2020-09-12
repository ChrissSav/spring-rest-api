package com.example.BaseApi.handler;

import com.example.BaseApi.exceptions.ApiException;
import com.example.BaseApi.exceptions.ConflictException;
import com.example.BaseApi.exceptions.ErrorResponse;
import com.example.BaseApi.exceptions.ExceptionCodes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionsHandlers {

    @ExceptionHandler(value = {ConflictException.class})
    public ResponseEntity<Object> handleApiException(ConflictException conflictException) {
        return new ResponseEntity<>(new ErrorResponse(conflictException), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(new ErrorResponse(ExceptionCodes.NOT_VALID_PAYLOAD), HttpStatus.UNPROCESSABLE_ENTITY);
    }


    @ExceptionHandler(value = {ApiException.class})
    public ResponseEntity<Object> handleApiException(ApiException apiException) {
        return new ResponseEntity<>(new ErrorResponse(apiException), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(AuthenticationException.class)
    //@ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<Object> test(ApiException apiException) {
        return new ResponseEntity<>(new ErrorResponse("rgergregergregrg"), HttpStatus.BAD_REQUEST);
    }
}


