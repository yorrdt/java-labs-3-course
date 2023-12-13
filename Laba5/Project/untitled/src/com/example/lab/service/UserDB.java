package com.example.lab.service;

import com.example.lab.model.Database;
import com.example.lab.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDB extends Database {

    @Override
    public void createEntry(String userInfo) {

        try {
            FileWriter writer = new FileWriter("./data/users.txt");
            writer.write(userInfo);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String[] getEntryById(int id) {

        try {
            FileReader reader = new FileReader("./data/users.txt");
            BufferedReader buffReader = new BufferedReader(reader);

            String line = buffReader.readLine();
            while (line != null) {
                String[] userInfo = line.split(":");

                if (id == Integer.parseInt(userInfo[0])) {
                    return userInfo;
                }

                line = buffReader.readLine();
            }

            buffReader.close();
            reader.close();

            System.out.println("[UserDB]: User not found!");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<User> getAllEntries() {

        List<User> entriesList = new ArrayList<>();

        try {
            FileReader reader = new FileReader("./data/users.txt");
            BufferedReader buffReader = new BufferedReader(reader);

            String line = buffReader.readLine();
            while (line != null) {
                String[] userInfo = line.split(":");

                User user = new User();
                user.setId(Integer.parseInt(userInfo[0]));
                user.setName(userInfo[1]);
                user.setPassword(userInfo[2]);
                user.setAuthenticated(Boolean.parseBoolean(userInfo[3]));
                user.setRole(Integer.parseInt(userInfo[4]));

                entriesList.add(user);

                line = buffReader.readLine();
            }

            buffReader.close();
            reader.close();

            return entriesList;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return new ArrayList<User>();
    }

    public void setUserAuthenticated(boolean isAuthenticated) {
        
    }

    @Override
    public void updateEntry(int id) {

    }

    @Override
    public void deleteEntryById(int id) {

    }
}
