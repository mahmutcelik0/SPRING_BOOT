package com.mahmutcelik.demo.controller;

import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WelcomeController {
    @GetMapping("/welcomePage")
    public String getWelcomePage(){
        return "WELCOME PAGE WITH SECURITY";
    }
}
