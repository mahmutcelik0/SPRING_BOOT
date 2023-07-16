package com.mahmutcelik.demo.repository;

import com.mahmutcelik.demo.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loans,Long> {

    List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);
}
