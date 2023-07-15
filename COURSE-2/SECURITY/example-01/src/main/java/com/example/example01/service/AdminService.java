package com.example.example01.service;

import com.example.example01.model.Admin;
import com.example.example01.repository.AdminRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAdminByEmail(String email){
        List<Admin> adminList = adminRepository.getAdminByEmail(email);

        if(adminList.isEmpty()){
            throw new BadCredentialsException("Bad Credentials");
        }

        return adminList;
    }

}
