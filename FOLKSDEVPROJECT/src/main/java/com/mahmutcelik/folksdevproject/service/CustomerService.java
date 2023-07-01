package com.mahmutcelik.folksdevproject.service;


import com.mahmutcelik.folksdevproject.exception.CustomerNotFoundException;
import com.mahmutcelik.folksdevproject.model.Customer;
import com.mahmutcelik.folksdevproject.repository.CustomerRepository;
import org.springframework.stereotype.Service;


/*
* Dökumantasyonda elimizde customer ların bulunduğu ve bu customer lara account lar açılacağını söylüyor.
* Bunu yapmak için öncelikle CustomerService te verilen id ye uygun customer ın var olup olmadığını kontrol etmeliyiz
*
* */
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    protected Customer findById (String id){
        return customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("Customer could not find by id: "+ id)); // findById() repository ye ait bir metod ve orElseThrow da exception fırlatıyor gerekli durumda
        //gelen id de bir customer i repository de bulamazsa tanımladığımız customernotfound exception fırlatılmalı
    }
}
