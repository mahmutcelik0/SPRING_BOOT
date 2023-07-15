package com.example.example01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mainPage")
public class MainPageController {
    @GetMapping
    private String getMainPage(){
        return "Welcome to the Main Page";
    }
}
