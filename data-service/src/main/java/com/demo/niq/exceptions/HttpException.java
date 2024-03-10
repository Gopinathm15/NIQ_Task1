package com.demo.niq.exceptions;

import java.io.Serial;

public class HttpException extends AppException {

    public HttpException() {
        super();
    }

    public HttpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public HttpException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpException(String message, String code) {
        super(message, code);
    }

    public HttpException(String code) {
        super(code);
    }

    public HttpException(Throwable cause) {
        super(cause);
    }
}
