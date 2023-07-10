package com.example.employee_project_w_jpa.controller;

import com.example.employee_project_w_jpa.dto.UserDto;
import com.example.employee_project_w_jpa.model.User;
import com.example.employee_project_w_jpa.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{username}")
    public UserDto getUser(@PathVariable String username){
        return userService.getUserByUsername(username);
    }

    @PostMapping
    public void addNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }
}
