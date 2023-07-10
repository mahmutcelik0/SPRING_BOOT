package com.example.employee_project_w_jpa.repository;

import com.example.employee_project_w_jpa.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("select r from Role as r")
    List<Role> getAllRoles();

    Role save(Role role);

    @Query("select r from Role as r where r.name =? 1")
    List<Role> findByRoleName(String roleName);

}
