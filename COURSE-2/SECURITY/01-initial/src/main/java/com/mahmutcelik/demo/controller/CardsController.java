package com.mahmutcelik.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CardsController {
    @GetMapping("/cars")
    public String getCardsDetails(){
        return "Here are the cards details from the DB";
    }
}
