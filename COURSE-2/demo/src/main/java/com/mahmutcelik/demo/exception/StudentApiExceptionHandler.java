package com.mahmutcelik.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentApiExceptionHandler {
    //EXCEPTION HANDLER FOR GLOBAL
    //StudentNotFoundException larını handle eder
    //RESPONSE ENTITY ICERISINE OLUSTURDUGUMUZ RESPONSE CLASS I VE HTTP STATUS U EKLENIP RETURN EDILIYOR
    //STUDENT NOT FOUND EXPCETION OLUSURSA BU CONTROLLER DA BU CLASS CALISIYOR
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handler(StudentNotFoundException exception){
        StudentErrorResponse errorResponse = new StudentErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    //StudentNotFound harici exception lar throw olduğunda burası handle edecek
    //int yerine aa girilirse mesela
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> genericHandler(Exception exception){
        StudentErrorResponse errorResponse = new StudentErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
