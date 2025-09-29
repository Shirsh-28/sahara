package com.ecommerce.project.exceptions;

public class APIException extends RuntimeException{
    private static final long serialVersionUID= 1L;
    String message;

    public APIException() {
    }

    public APIException(String message) {
        super(message);
        this.message = message;
    }
}
