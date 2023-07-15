package com.example.example01.repository;

import com.example.example01.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {


    List<Admin> getAdminByEmail(String email);
}
