package com.mahmutcelik.demo1.exception;

public class LocationNotFoundException extends Exception{
    public LocationNotFoundException() {
        super("THERE IS ANY LOCATION DATA FOUND");
    }
}
