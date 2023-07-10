package com.example.employee_project_w_jpa.dto;

import com.example.employee_project_w_jpa.model.User;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private boolean enabled;

    public static UserDto perform(User user){
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEnabled(user.isEnabled());
        return userDto;
    }
}
