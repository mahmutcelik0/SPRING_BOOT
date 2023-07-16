package com.mahmutcelik.demo.service;

import com.mahmutcelik.demo.model.Customer;
import com.mahmutcelik.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findByEmail(String name) {
        return customerRepository.findByEmail(name);
    }
}
