package com.example.user_project_w_jwt.repository;

import com.example.user_project_w_jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,Long> {

    User findFirstByEmail(String email);
}
