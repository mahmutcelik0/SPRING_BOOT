package com.example.user_project_w_jwt.dto;

import com.example.user_project_w_jwt.model.User;
import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String email;

    public UserDto perform(User user) {
        UserDto userDto = new UserDto();

        userDto.name = user.getName();
        userDto.email = user.getEmail();

        return userDto;
    }
}
