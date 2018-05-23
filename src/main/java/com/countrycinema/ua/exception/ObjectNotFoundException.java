package com.countrycinema.ua.exception;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends InternalException {
    private static final String DEFAULT_MESSAGE = "Object not found";

    public ObjectNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public ObjectNotFoundException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }

}
