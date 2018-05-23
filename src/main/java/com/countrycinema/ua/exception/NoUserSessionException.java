package com.countrycinema.ua.exception;

import org.springframework.http.HttpStatus;

public class NoUserSessionException extends InternalException {
    public NoUserSessionException() {
    }

    public NoUserSessionException(Throwable cause) {
        super(cause);
    }

    public NoUserSessionException(String message) {
        super(message);
    }

    public NoUserSessionException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }

}
