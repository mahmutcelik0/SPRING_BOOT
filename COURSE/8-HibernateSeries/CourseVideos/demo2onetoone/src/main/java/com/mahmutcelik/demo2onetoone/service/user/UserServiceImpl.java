package com.mahmutcelik.demo2onetoone.service.user;

import com.mahmutcelik.demo2onetoone.model.Users;
import com.mahmutcelik.demo2onetoone.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Users addNewUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users updateUser(Users user, Long id) {
        return userRepository.findById(id).map(e-> userRepository.save(user)).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
