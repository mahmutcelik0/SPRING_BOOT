package com.mahmutcelik.demo1.service.user;

import com.mahmutcelik.demo1.exception.UserNotFoundException;
import com.mahmutcelik.demo1.model.Post;
import com.mahmutcelik.demo1.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers() throws UserNotFoundException;

    User getUserById(Long id) throws UserNotFoundException;

    User addNewUser(User user);

    User updateUser(Long id, User user) throws UserNotFoundException;

    void deleteUser(Long id);
}
