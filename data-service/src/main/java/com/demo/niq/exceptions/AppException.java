package com.demo.niq.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends RuntimeException {
    private String message;
    private String code;

    public AppException(String code) {
        this.code = code;
    }

    public AppException() {
        super();
    }

    public AppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(String message, String code) {
        this.code = code;
        this.message = message;
    }

    public AppException(Throwable cause) {
        super(cause);
    }
}