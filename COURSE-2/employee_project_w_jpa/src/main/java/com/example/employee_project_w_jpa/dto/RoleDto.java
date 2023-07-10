package com.example.employee_project_w_jpa.dto;

import com.example.employee_project_w_jpa.model.Role;
import lombok.Data;

@Data
public class RoleDto {
    private String name;

    public static RoleDto perform(Role role){
        RoleDto roleDto = new RoleDto();
        roleDto.setName(role.getName());
        return roleDto;
    }

}
