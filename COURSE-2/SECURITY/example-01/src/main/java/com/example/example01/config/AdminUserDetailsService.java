package com.example.example01.config;

import com.example.example01.model.Admin;
import com.example.example01.service.AdminService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Dbden kendi admin imizi okuyup authentication provider da kullanmak için kendi user details service imizi yazdık
@Service
public class AdminUserDetailsService implements UserDetailsService {
    private final AdminService adminService;

    public AdminUserDetailsService(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminService.getAdminByEmail(username).get(0);

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(admin.getRoles()));
        return new User(admin.getEmail(),admin.getPassword(),authorities);
    }
}
