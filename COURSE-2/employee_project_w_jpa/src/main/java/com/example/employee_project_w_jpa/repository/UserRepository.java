package com.example.employee_project_w_jpa.repository;

import com.example.employee_project_w_jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User as u")
    List<User> getAllUsers();

    Optional<User> getUserByUsername(String username);
}
