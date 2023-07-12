package com.mahmutcelik.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notices")
public class NoticesController {
    @GetMapping
    public String getNoticesDetails(){
        return "Here are the notices details from the DB";
    }
}
