package com.example.BaseApi.exceptions;

public class ApiException extends RuntimeException {

    private Integer statusCode;
    private String msg;
    private Integer httpCode;

    public ApiException() {
    }


    public Integer getStatusCode() {
        return statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public ApiException(ExceptionCodes exceptionCodes) {
        this.statusCode = exceptionCodes.getCode();
        this.msg = exceptionCodes.getDescription();
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
