package io.swagger.exceptions;

public class BadUsernameException extends RuntimeException {
    public BadUsernameException() {
        super();
    }

    public BadUsernameException(String message) {
        super(message);
    }

    public BadUsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadUsernameException(Throwable cause) {
        super(cause);
    }

    protected BadUsernameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
