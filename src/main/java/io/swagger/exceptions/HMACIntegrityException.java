package io.swagger.exceptions;

public class HMACIntegrityException extends RuntimeException{
    public HMACIntegrityException() {
        super();
    }

    public HMACIntegrityException(String message) {
        super(message);
    }

    public HMACIntegrityException(String message, Throwable cause) {
        super(message, cause);
    }

    public HMACIntegrityException(Throwable cause) {
        super(cause);
    }

    protected HMACIntegrityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
