package com.mahmutcelik.folksdevproject.repository;

import com.mahmutcelik.folksdevproject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
