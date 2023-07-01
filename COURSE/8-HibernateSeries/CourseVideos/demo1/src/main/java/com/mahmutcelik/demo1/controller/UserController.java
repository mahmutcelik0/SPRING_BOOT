package com.mahmutcelik.demo1.controller;

import com.mahmutcelik.demo1.exception.UserNotFoundException;
import com.mahmutcelik.demo1.model.Post;
import com.mahmutcelik.demo1.model.User;
import com.mahmutcelik.demo1.service.user.UserService;
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
    private List<User> getAllUsers() throws UserNotFoundException {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    private User getUserById(@PathVariable Long id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @GetMapping("/user/{id}/posts")
    private List<Post> getPostsofUser(@PathVariable Long id) throws UserNotFoundException {
        return userService.getUserById(id).getPosts();
    }

    @PostMapping("/user")
    private User addNewUser(@RequestBody User user){
        return userService.addNewUser(user);
    }

    @PutMapping("/user/{id}")
    private User updateUser(@PathVariable("id") Long id,User user) throws UserNotFoundException {
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/user/{id}")
    private void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

}
