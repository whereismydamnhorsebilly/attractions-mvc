package com.springApp.exceptions;

public class RequestArgumentsFailureException extends RuntimeException {

    public RequestArgumentsFailureException(String message) {
        super(message);
    }
}
