package com.example.user_project_w_jwt.service.auth;

import com.example.user_project_w_jwt.dto.UserDto;
import com.example.user_project_w_jwt.model.User;

public interface AuthService {
    UserDto createUser(User user);
}
