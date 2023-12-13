package com.example.lab5.config;

import com.example.lab5.database.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {

    public final static String url = "jdbc:postgresql://localhost:5432/lab5db";
    public final static String user = "postgres";
    public final static String password = "postgres";
    private static Connection connection = null;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
