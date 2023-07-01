package com.mahmutcelik.folksdevproject.service;

import com.mahmutcelik.folksdevproject.dto.AccountDto;
import com.mahmutcelik.folksdevproject.dto.CreateAccountRequest;
import com.mahmutcelik.folksdevproject.model.Customer;
import com.mahmutcelik.folksdevproject.repository.AccountRepository;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;



    public AccountService(AccountRepository accountRepository, CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer customer = customerService.findById(createAccountRequest.getCustomerId());
    }




}
