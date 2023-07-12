package com.mahmutcelik.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoanController {
    @GetMapping
    public String getLoansDetails(){
        return "Here are the loans details from the DB";
    }
}
