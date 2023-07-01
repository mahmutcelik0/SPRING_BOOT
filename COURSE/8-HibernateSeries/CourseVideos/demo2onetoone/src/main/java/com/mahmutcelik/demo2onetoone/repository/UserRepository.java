package com.mahmutcelik.demo2onetoone.repository;

import com.mahmutcelik.demo2onetoone.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
}
