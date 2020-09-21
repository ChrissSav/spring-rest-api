package com.example.BaseApi.exceptions;

public enum ExceptionCodes {
    NOT_VALID_PAYLOAD(10, "Not valid payload"),
    EMAIL_ALREADY_EXIST(15, "Email already exist"),
    ACCESS_DENIED(15, "Failed to verify"),
    SOMETHING_WRONG(-10, "SOMETHING_WRONG"),
    POST_NOT_BELONG_TO_USER(-10, "POST_NOT_BELONG_TO_USER"),
    POST_NOT_FOUND(50, "POST_NOT_FOUND");


    private int code;
    private String description;
    private int httpCode;

    ExceptionCodes(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }


}
