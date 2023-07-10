package com.example.employee_project_w_jpa.service;

import com.example.employee_project_w_jpa.dto.UserDto;
import com.example.employee_project_w_jpa.exception.RoleNotFoundException;
import com.example.employee_project_w_jpa.exception.UserNotFoundException;
import com.example.employee_project_w_jpa.model.Role;
import com.example.employee_project_w_jpa.model.User;
import com.example.employee_project_w_jpa.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    public List<UserDto> getAllUsers() {
        return userRepository.getAllUsers()
                .stream()
                .map(UserDto::perform)
                .toList();
    }

    public UserDto getUserByUsername(String username) {
        Optional<User> user = userRepository.getUserByUsername(username);
        if(user.isEmpty()){
            throw new UserNotFoundException("User Not Found");
        }
        return UserDto.perform(user.get());
    }

    public void addNewUser(User user) {
        findRoleAndSave(user);
        System.out.println(user.getRoles());
        userRepository.save(user);
    }

    public void findRoleAndSave(User user){
        List<Role> roleNames = user.getRoles();
        List<Role> userRoles =new ArrayList<>();
        for (Role role : roleNames) {
            try {
                Role role1 = roleService.findRoleByName(role.getName());
                System.out.println(role1);
                userRoles.add(role1);
            }catch (RoleNotFoundException e){
                throw new RuntimeException(e.getMessage());
            }
        }
        System.out.println("ENTERED"+ userRoles);
        user.setRoles(userRoles);
    }
}
