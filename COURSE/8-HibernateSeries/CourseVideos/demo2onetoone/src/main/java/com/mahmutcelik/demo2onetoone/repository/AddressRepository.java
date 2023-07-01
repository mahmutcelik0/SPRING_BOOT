package com.mahmutcelik.demo2onetoone.repository;

import com.mahmutcelik.demo2onetoone.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
