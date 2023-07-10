package com.example.user_project_w_jwt.dto;

import lombok.Data;

@Data
public class AuthenticationDto {
    private String email;
    private String password;
}
