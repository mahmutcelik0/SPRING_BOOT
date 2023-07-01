package com.mahmutcelik.demo1.exception;

public class PostNotFoundException extends Exception{
    public PostNotFoundException() {
        super("THERE IS ANY POST DATA FOUND");
    }
}
