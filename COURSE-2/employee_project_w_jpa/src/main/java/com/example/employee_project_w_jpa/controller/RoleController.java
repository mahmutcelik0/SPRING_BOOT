package com.example.employee_project_w_jpa.controller;

import com.example.employee_project_w_jpa.dto.RoleDto;
import com.example.employee_project_w_jpa.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    private List<RoleDto> getAllRoles(){
        return roleService.getAllRoles();
    }

    @PostMapping
    private void addNewRole(@RequestBody RoleDto roleDto){
        roleService.addNewRole(roleDto);
    }
}
