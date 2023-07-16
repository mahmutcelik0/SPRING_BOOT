package com.mahmutcelik.demo.controller;

import com.mahmutcelik.demo.model.Customer;
import com.mahmutcelik.demo.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    private final CustomerService customerService;

    private final PasswordEncoder passwordEncoder;

    public LoginController(CustomerService customerService, PasswordEncoder passwordEncoder) {
        this.customerService = customerService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        Customer savedCustomer = null;
        ResponseEntity responseEntity = null;
        try {
            customer.setPwd(passwordEncoder.encode(customer.getPwd()));
            savedCustomer = customerService.save(customer);
            if(savedCustomer.getId() > 0){
                responseEntity = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
        }catch (Exception ex){
            responseEntity = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to" + ex.getMessage());
        }
        return responseEntity;
    }

    @GetMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication){ //Authentication object provided by spring security automatically
        List<Customer> customers = customerService.findByEmail(authentication.getName());
        return customers.get(0);
    }





}
