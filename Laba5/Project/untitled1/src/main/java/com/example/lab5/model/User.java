package com.example.lab5.model;

public class User {
    private int id;
    private String name;
    private String password;
    private boolean isAuthenticated;
    private int role;

    public User() {}

    public User(int id, String name, String password, boolean isAuthenticated, int role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.isAuthenticated = isAuthenticated;
        this.role = role;
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

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public void setRole(int role) {
        this.role = role;
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

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public int getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", isAuthenticated=" + isAuthenticated +
                '}';
    }
}
