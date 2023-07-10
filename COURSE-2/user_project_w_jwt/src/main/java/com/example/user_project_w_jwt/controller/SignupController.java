package com.example.user_project_w_jwt.controller;

import com.example.user_project_w_jwt.dto.UserDto;
import com.example.user_project_w_jwt.model.User;
import com.example.user_project_w_jwt.service.auth.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SignupController {
    private final AuthService authService;

    public SignupController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@RequestBody User user){
        UserDto userDto = authService.createUser(user);

        if(userDto==null){
            return new ResponseEntity<>("User not created", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User Created Successfully",HttpStatus.CREATED);

    }

}
