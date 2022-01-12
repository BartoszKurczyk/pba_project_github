package io.swagger.exceptions;

public class BadPasswordExcepiton extends RuntimeException{
    public BadPasswordExcepiton() {
        super();
    }

    public BadPasswordExcepiton(String message) {
        super(message);
    }

    public BadPasswordExcepiton(String message, Throwable cause) {
        super(message, cause);
    }

    public BadPasswordExcepiton(Throwable cause) {
        super(cause);
    }

    protected BadPasswordExcepiton(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
