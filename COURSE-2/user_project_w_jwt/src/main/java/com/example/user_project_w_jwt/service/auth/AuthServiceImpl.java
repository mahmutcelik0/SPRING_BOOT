package com.example.user_project_w_jwt.service.auth;

import com.example.user_project_w_jwt.dto.UserDto;
import com.example.user_project_w_jwt.model.User;
import com.example.user_project_w_jwt.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword())); //BCRYPT ENCODING
        UserDto userDto = new UserDto().perform(userRepository.save(user));
        return userDto;
    }
}
