package com.example.example01.config;

import com.example.example01.model.Admin;
import com.example.example01.model.Gender;
import com.example.example01.service.AdminService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminUsernamePasswordAuthenticationProvider implements AuthenticationProvider {
    private final AdminService adminService;
    private final PasswordEncoder passwordEncoder;

    public AdminUsernamePasswordAuthenticationProvider(AdminService adminService, PasswordEncoder passwordEncoder) {
        this.adminService = adminService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        List<Admin> adminList = adminService.getAdminByEmail(authentication.getName());

        if (adminList.isEmpty()){
            throw new BadCredentialsException("Bad Credentials");
        }

        Admin admin = adminList.get(0);

        boolean matches = passwordEncoder.matches(authentication.getCredentials().toString(),admin.getPassword());

        if(!matches){
            throw new BadCredentialsException("Bad Credentials");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(admin.getRoles()));
        return new UsernamePasswordAuthenticationToken(admin.getEmail(),admin.getPassword(),authorities); //Token ı oluşturduk ve provider manager a döndürüyoruz
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
