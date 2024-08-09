package com.cloud_dp.users_pictures_microservice.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        // Log the exception, return custom response, etc.
        return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
