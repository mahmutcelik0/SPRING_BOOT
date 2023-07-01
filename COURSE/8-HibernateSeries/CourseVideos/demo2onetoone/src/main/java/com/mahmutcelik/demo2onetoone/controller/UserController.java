package com.mahmutcelik.demo2onetoone.controller;

import com.mahmutcelik.demo2onetoone.model.Users;
import com.mahmutcelik.demo2onetoone.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    private List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    private Users getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    private Users addNewUser(@RequestBody Users user){
        return userService.addNewUser(user);
    }

    @PutMapping("/user/{id}")
    private Users updateUser(@RequestBody Users user, @PathVariable Long id){
        return userService.updateUser(user,id);
    }

    @DeleteMapping("/user/{id}")
    private void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
