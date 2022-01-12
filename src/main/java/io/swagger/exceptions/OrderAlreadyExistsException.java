package io.swagger.exceptions;

public class OrderAlreadyExistsException extends RuntimeException{
    public OrderAlreadyExistsException() {
        super();
    }

    public OrderAlreadyExistsException(String message) {
        super(message);
    }

    public OrderAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected OrderAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
