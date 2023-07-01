package com.mahmutcelik.demo.facade;

import com.mahmutcelik.demo.dto.UserDto;
import com.mahmutcelik.demo.exception.UserNotFoundException;
import com.mahmutcelik.demo.model.User;

public interface UserFacade {
    UserDto getUserByUsername(String username) throws UserNotFoundException;

    UserDto deleteUserByUsername(String username) throws UserNotFoundException;

    UserDto updateByUsername(String username,User user);
}
