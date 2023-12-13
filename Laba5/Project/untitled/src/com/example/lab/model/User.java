package com.example.lab.model;

import java.util.HashMap;
import java.util.Map;

public class User {

    private int id;
    private String name;
    private String password;
    private boolean isAuthenticated;
    private int role;

    public void addUser(int id, String name, String password, boolean isAuthenticated, int role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.isAuthenticated = isAuthenticated;
        this.role = role;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public String getStringRole() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Admin");
        map.put(1, "Manager");
        map.put(2, "Driver");

        return map.get(this.role);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
