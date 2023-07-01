package com.mahmutcelik.demo.dto;

import com.mahmutcelik.demo.model.User;

public class UserDtoMapper {
    public static UserDto convert(User user){
        UserDto userDto = new UserDto();

        userDto.setUsername(user.getUsername());
        userDto.setCity(user.getCity());
        userDto.setIsAdmin(user.getIsAdmin());
        userDto.setSalary(user.getSalary());

        return userDto;
    }
}