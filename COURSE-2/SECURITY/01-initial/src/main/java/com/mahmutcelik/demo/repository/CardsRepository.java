package com.mahmutcelik.demo.repository;

import com.mahmutcelik.demo.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardsRepository extends JpaRepository<Cards,Long> {
    List<Cards> findByCustomerId(int customerId);
}
