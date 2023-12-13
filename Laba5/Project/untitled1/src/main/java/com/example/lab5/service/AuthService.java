package com.example.lab5.service;

import com.example.lab5.database.UserService;
import com.example.lab5.model.User;

import java.util.List;

public class AuthService {

    private final UserService userService = new UserService();

    public User loginUser(String name, String password) {
        List<User> userList = userService.getAllUsers();

        for (User user : userList) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                userService.updateUserAuth(user.getId(), true);
                user.setAuthenticated(true);
                return user;
            }
        }

        System.err.println("User doesn't exists!");
        return null;
    }
}
