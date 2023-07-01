package com.example.asyncproblembackend.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @GetMapping("/user")
    private String getUser(){
        long startOfExecution = System.nanoTime();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        return "System responses in :" + (System.nanoTime() - startOfExecution) + " time.";
    }

    @GetMapping("/product")
    private String getProduct(){
        long startOfExecution = System.nanoTime();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        return "System responses in :" + (System.nanoTime() - startOfExecution) + " time.";
    }
}
