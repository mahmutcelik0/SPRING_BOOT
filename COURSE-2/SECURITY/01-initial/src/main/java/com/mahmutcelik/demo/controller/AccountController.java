package com.mahmutcelik.demo.controller;

import com.mahmutcelik.demo.model.Accounts;
import com.mahmutcelik.demo.repository.AccountsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountsRepository accountsRepository;

    public AccountController(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @GetMapping
    public Accounts getAccountDetails(@RequestParam int id){
        Accounts accounts = accountsRepository.findByCustomerId(id);
        return accounts;
    }
}
