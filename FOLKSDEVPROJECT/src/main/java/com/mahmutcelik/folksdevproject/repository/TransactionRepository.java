package com.mahmutcelik.folksdevproject.repository;

import com.mahmutcelik.folksdevproject.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,String> {
}
