package com.demo.niq.exceptions;

public class BadRequestHttpException extends HttpException {
    public BadRequestHttpException() {
        super();
    }

    public BadRequestHttpException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BadRequestHttpException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestHttpException(String code) {
        super(code);
    }

    public BadRequestHttpException(Throwable cause) {
        super(cause);
    }

}
