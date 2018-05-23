package com.countrycinema.ua.exception;

import org.springframework.http.HttpStatus;

public class BadInputParamException extends InternalException {
    private static final String DEFAULT_MESSAGE = "Please, contact your admin";

    public BadInputParamException() {
        super(DEFAULT_MESSAGE);
    }

    public BadInputParamException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public BadInputParamException(String message) {
        super(message);
    }

    public BadInputParamException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }

}
