package com.example.employee_project_w_jpa.service;

import com.example.employee_project_w_jpa.dto.UserDto;
import com.example.employee_project_w_jpa.exception.UserNotFoundException;
import com.example.employee_project_w_jpa.model.User;
import com.example.employee_project_w_jpa.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        userRepository.save(user);
    }
}
