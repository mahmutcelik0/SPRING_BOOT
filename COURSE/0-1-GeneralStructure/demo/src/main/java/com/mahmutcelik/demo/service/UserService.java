package com.mahmutcelik.demo.service;

import com.mahmutcelik.demo.dto.UserDto;
import com.mahmutcelik.demo.exception.UserNotFoundException;
import com.mahmutcelik.demo.model.User;
import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserByUsername(String username) throws UserNotFoundException;

    void deleteAllUsers();

    UserDto deleteUserByUsername(String username) throws UserNotFoundException;

    UserDto addNewUser(User user);

    UserDto updateByUsername(String username,User user) throws UserNotFoundException;
}
