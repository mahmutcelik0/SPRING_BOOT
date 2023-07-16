package com.mahmutcelik.demo.repository;

import com.mahmutcelik.demo.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts,Long> {

    Accounts findByCustomerId(int customerId);
}
