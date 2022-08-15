package com.florb.UserManagement.service;

import com.florb.UserManagement.model.Role;
import com.florb.UserManagement.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    User saveUser(User user);

    Optional<User> findUserByUsername(String username);

    void changeRole(Role newRole, String username);

    List<User> findAllUsers();
}
