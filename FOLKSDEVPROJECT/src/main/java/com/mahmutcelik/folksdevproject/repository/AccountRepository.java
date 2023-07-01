package com.mahmutcelik.folksdevproject.repository;

import com.mahmutcelik.folksdevproject.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
