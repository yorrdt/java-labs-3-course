package com.example.lab.service;

import com.example.lab.model.User;

import java.util.List;
import java.util.Scanner;

public class AuthService {

    private final UserDB userDB = new UserDB();

    public User loginUser(String name, String password) {

        List<User> entriesList = userDB.getAllEntries();

        for (User user : entriesList) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return new User();
    }
}
