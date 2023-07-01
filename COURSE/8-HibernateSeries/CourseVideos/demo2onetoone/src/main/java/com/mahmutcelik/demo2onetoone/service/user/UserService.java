package com.mahmutcelik.demo2onetoone.service.user;

import com.mahmutcelik.demo2onetoone.model.Users;

import java.util.List;

public interface UserService {
    List<Users> getAllUsers();

    Users getUserById(Long id);

    Users addNewUser(Users user);

    Users updateUser(Users user, Long id);

    void deleteUser(Long id);
}
