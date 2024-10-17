package com.springApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class RequestArgumentsFailureExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<IncorrectDataTemplate> exceptionHandler(RequestArgumentsFailureException exception) {
        IncorrectDataTemplate data = new IncorrectDataTemplate();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
