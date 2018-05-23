package com.countrycinema.ua.exception;

import org.springframework.http.HttpStatus;

public class InternalException extends RuntimeException {
    public static final String INTERNAL_SERVER_ERROR = "Please, contact your admin";

    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    private String message = INTERNAL_SERVER_ERROR;

    public InternalException() {
    }

    public InternalException(Throwable cause) {
        super(cause);
    }

    public InternalException(String message) {
        this.message = message;
    }

    public InternalException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
