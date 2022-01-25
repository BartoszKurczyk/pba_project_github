package io.swagger.exceptions;

import io.swagger.model.Error;
import io.swagger.model.ResponseHeader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Date;
import java.util.UUID;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Error> handleRuntimeException(RuntimeException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(ResponseHeader.builder().sendDate(new Date()).responseId(UUID.randomUUID()).build());
        error.code("500");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Error> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(ResponseHeader.builder().sendDate(new Date()).responseId(UUID.randomUUID()).build());
        error.code("400");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Error> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(ResponseHeader.builder().sendDate(new Date()).responseId(UUID.randomUUID()).build());
        error.code("400");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(BadUsernameException.class)
    public ResponseEntity<Error> handleBadUsernameException(BadUsernameException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(ResponseHeader.builder().sendDate(new Date()).responseId(UUID.randomUUID()).build());
        error.code("401");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(BadPasswordExcepiton.class)
    public ResponseEntity<Error> handleBadPasswordExcepiton(BadPasswordExcepiton ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(ResponseHeader.builder().sendDate(new Date()).responseId(UUID.randomUUID()).build());
        error.code("401");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> handleUserNotFound(UserNotFoundException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(ResponseHeader.builder().sendDate(new Date()).responseId(UUID.randomUUID()).build());
        error.code("USER_NOT_FOUND");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Error> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(ResponseHeader.builder().sendDate(new Date()).responseId(UUID.randomUUID()).build());
        error.code("PRODUCT_NOT_FOUND");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(OrderNotFound.class)
    public ResponseEntity<Error> handleOrderNotFound(OrderNotFound ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(ResponseHeader.builder().sendDate(new Date()).responseId(UUID.randomUUID()).build());
        error.code("ORDER_NOT_FOUND");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NotEnoughProductException.class)
    public ResponseEntity<Error> handleNotEnoughProductException(NotEnoughProductException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(ResponseHeader.builder().sendDate(new Date()).responseId(UUID.randomUUID()).build());
        error.code("NOT_ENAUGH_PRODUCTS");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(OrderAlreadyExistsException.class)
    public ResponseEntity<Error> handleOrderAlreadyExistsException(OrderAlreadyExistsException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(ResponseHeader.builder().sendDate(new Date()).responseId(UUID.randomUUID()).build());
        error.code("ORDER_ALREADY_EXISTS_EXCEPTION");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<Error> handleProductAlreadyExistsException(ProductAlreadyExistsException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(ResponseHeader.builder().sendDate(new Date()).responseId(UUID.randomUUID()).build());
        error.code("PRODUCT_ALREADY_EXISTS_EXCEPTION");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Error> handleUserAlreadyExistsException(UserAlreadyExistsException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(ResponseHeader.builder().sendDate(new Date()).responseId(UUID.randomUUID()).build());
        error.code("USER_ALREADY_EXISTS_EXCEPTION");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(HMACIntegrityException.class)
    public ResponseEntity<Error> handleHMACIntegrityException(HMACIntegrityException ex, WebRequest request) {
        Error error = new Error();
        error.setResponseHeader(ResponseHeader.builder().sendDate(new Date()).responseId(UUID.randomUUID()).build());
        error.code("400");
        error.message(ex.getMessage());
        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }
}
