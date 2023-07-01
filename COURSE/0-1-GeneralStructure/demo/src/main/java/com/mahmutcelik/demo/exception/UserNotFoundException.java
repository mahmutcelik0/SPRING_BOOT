package com.mahmutcelik.demo.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("USER NOT EXIST");
    }




}
