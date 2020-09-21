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

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ExceptionsHandlers {

    @ExceptionHandler(value = {ConflictException.class})
    public ResponseEntity<ErrorResponse> handleApiException(ConflictException conflictException) {
        return new ResponseEntity(new ErrorResponse(conflictException), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        return new ResponseEntity(new ErrorResponse(ExceptionCodes.NOT_VALID_PAYLOAD), HttpStatus.UNPROCESSABLE_ENTITY);
    }


    @ExceptionHandler(value = {ApiException.class})
    public ResponseEntity<ErrorResponse> handleApiException(ApiException apiException) {
        return new ResponseEntity(new ErrorResponse(apiException), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponse> test(AuthenticationException apiException) {
        return new ResponseEntity(new ErrorResponse("rgergregergregrg"), HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorResponse> runtimeExceptionHandler(HttpServletRequest request, Exception apiException) {
        return new ResponseEntity(new ErrorResponse(ExceptionCodes.SOMETHING_WRONG), HttpStatus.UNPROCESSABLE_ENTITY);
    }

}


