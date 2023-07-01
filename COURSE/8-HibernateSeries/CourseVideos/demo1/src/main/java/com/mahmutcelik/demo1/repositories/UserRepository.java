package com.mahmutcelik.demo1.repositories;

import com.mahmutcelik.demo1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Long> {
}
