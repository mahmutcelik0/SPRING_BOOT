package com.example.groupusecaseexample.repository;

import com.example.groupusecaseexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
