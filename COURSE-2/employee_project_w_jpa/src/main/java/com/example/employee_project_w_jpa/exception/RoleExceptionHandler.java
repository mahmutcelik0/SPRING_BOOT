package com.example.employee_project_w_jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RoleExceptionHandler {
    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleNotFoundException(RoleNotFoundException exc){
        return new ResponseEntity<>(ErrorResponse.create(exc, HttpStatus.NOT_FOUND,"ROLE NOT FOUND"),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleGeneralException(Exception exc){
        return new ResponseEntity<>(ErrorResponse.create(exc,HttpStatus.BAD_REQUEST,"EXCEPTION THROWED IN ROLE"),HttpStatus.BAD_REQUEST);
    }
}
