package com.example.employee_project_w_jpa.service;

import com.example.employee_project_w_jpa.dto.RoleDto;
import com.example.employee_project_w_jpa.model.Role;
import com.example.employee_project_w_jpa.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleDto> getAllRoles() {
        return roleRepository.getAllRoles()
                .stream()
                .map(RoleDto::perform)
                .toList();
    }

    public void addNewRole(RoleDto roleDto) {
        Role role = new Role();
        role.setName(roleDto.getName());
        roleRepository.save(role);
    }

    public Role findRoleByName(String roleName){
        return roleRepository.findByRoleName(roleName).get(0);
    }


}
