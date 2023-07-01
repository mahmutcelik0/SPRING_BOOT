package com.mahmutcelik.demo.repository;

import com.mahmutcelik.demo.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

    @Query("SELECT u FROM USERS u WHERE u.username = ?1")
    Optional<User> findByUsername(String username);

    @Transactional
    @Modifying
    @Query("DELETE FROM USERS u")
    void deleteAllUsers();




}
