package com.mahmutcelik.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BalanceController {
    @GetMapping("/balance")
    public String getBalanceDetails(){
        return "Here are the balance details from the DB";
    }
}
