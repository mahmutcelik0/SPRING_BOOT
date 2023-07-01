package com.mahmutcelik.demo.controller;

import com.mahmutcelik.demo.dto.UserDto;
import com.mahmutcelik.demo.facade.UserFacade;
import com.mahmutcelik.demo.model.User;
import com.mahmutcelik.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserFacade userFacade;
    private final UserService userService;

    public UserController(UserFacade userFacade, UserService userService) {
        this.userFacade = userFacade;
        this.userService = userService;
    }

    @GetMapping
    private List<UserDto> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{username}")
    private UserDto getUserByUsername(@PathVariable("username") String username){
        return userFacade.getUserByUsername(username);
    }

    @DeleteMapping
    private void deleteAllUsers(){
        userService.deleteAllUsers();
    }

    @DeleteMapping("/{username}")
    private UserDto deleteUserByUsername(@PathVariable("username") String username){
        return userFacade.deleteUserByUsername(username);
    }

    @PostMapping
    private UserDto addNewUser(@RequestBody User user){
        return userService.addNewUser(user);
    }

    @PutMapping("/{username}")
    private UserDto updateByUsername(@PathVariable("username") String username,@RequestBody User user){
        return userFacade.updateByUsername(username,user);
    }


}