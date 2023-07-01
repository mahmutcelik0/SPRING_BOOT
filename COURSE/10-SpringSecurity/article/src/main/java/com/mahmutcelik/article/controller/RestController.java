package com.mahmutcelik.article.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1")
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/user")
    private String getUser(){
        return "Hello I'm user";
    }

    @GetMapping("/admin")
    private String getAdmin(){
        return "Hello I'm admin";
    }
}
