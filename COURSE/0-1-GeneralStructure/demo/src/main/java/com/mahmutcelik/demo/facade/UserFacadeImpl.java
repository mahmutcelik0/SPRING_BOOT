package com.mahmutcelik.demo.facade;

import com.mahmutcelik.demo.dto.UserDto;
import com.mahmutcelik.demo.exception.UserNotFoundException;
import com.mahmutcelik.demo.model.User;
import com.mahmutcelik.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserFacadeImpl implements UserFacade{

    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto getUserByUsername(String username) throws UserNotFoundException{
        return userService.getUserByUsername(username);
    }

    @Override
    public UserDto deleteUserByUsername(String username) throws UserNotFoundException {
        return userService.deleteUserByUsername(username);
    }

    @Override
    public UserDto updateByUsername(String username, User user) {
        return userService.updateByUsername(username,user);
    }
}
