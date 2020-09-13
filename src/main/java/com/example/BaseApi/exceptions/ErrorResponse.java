package com.example.BaseApi.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer statusCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String message;


    public ErrorResponse(ExceptionCodes exceptionCodes) {
        this.statusCode = exceptionCodes.getCode();
        this.message = exceptionCodes.getDescription();
    }

    public ErrorResponse(ConflictException exceptionCodes) {
        this.statusCode = exceptionCodes.getStatusCode();
        this.message = exceptionCodes.getMsg();
    }

    public ErrorResponse(String message) {
        this.statusCode = -100;
        this.message = message;
    }

    public ErrorResponse(ApiException apiException) {
        this.statusCode = apiException.getStatusCode();
        this.message = apiException.getMsg();
    }

    public ErrorResponse(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
