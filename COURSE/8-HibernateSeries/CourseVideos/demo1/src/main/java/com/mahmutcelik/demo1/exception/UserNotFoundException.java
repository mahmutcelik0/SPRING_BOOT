package com.mahmutcelik.demo1.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("THERE IS ANY USER DATA FOUND");
    }
}
