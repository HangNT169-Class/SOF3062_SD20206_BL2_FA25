package com.poly.server.exception;

public class ApiException extends RuntimeException{

    // RuntimeException: da co san message loi
    private final String code;

    public String getCode() {
        return code;
    }

    public ApiException(String message, String code) {
        super(message);
        this.code = code;
    }
}
