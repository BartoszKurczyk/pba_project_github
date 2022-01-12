package io.swagger.exceptions;

public class NotEnoughProductException extends RuntimeException{
    public NotEnoughProductException() {
        super();
    }

    public NotEnoughProductException(String message) {
        super(message);
    }

    public NotEnoughProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughProductException(Throwable cause) {
        super(cause);
    }

    protected NotEnoughProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
