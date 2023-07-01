package com.mahmutcelik.demo1.service.user;

import com.mahmutcelik.demo1.exception.UserNotFoundException;
import com.mahmutcelik.demo1.model.User;
import com.mahmutcelik.demo1.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() throws UserNotFoundException {
        List<User> tempList = userRepository.findAll();
        if(tempList.size()>0) return tempList;
        throw new UserNotFoundException();
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException{
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) throws UserNotFoundException {
        return userRepository.findById(id).map(e -> userRepository.save(user)).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
