package com.example.BaseApi.exceptions;

public class ConflictException extends RuntimeException {

    private Integer statusCode;
    private String msg;

    public ConflictException() {
    }


    public Integer getStatusCode() {
        return statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public ConflictException(ExceptionCodes exceptionCodes) {
        this.statusCode = exceptionCodes.getCode();
        this.msg = exceptionCodes.getDescription();
    }

    public ConflictException(String message) {
        super(message);
    }

    public ConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConflictException(Throwable cause) {
        super(cause);
    }

    public ConflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
