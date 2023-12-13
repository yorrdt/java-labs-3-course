package com.example.lab5.database;

import com.example.lab5.config.DatabaseConnection;
import com.example.lab5.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final String tableName = "users";
    private final Connection connection = DatabaseConnection.getConnection();

    public void createTable() {

        final String query = "create table if not exists " + tableName + " " +
                "(id serial primary key, " +
                "name varchar(255) not null, " +
                "password varchar(255) not null, " +
                "is_auth boolean not null, " +
                "user_role_id integer references user_roles(id) on delete cascade" +
                ");";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            logger.info("Execute create " + tableName + " table");
        } catch (SQLException e) {
            // System.err.println("UserService: " + e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }
    }

    public void addUser(User user) {

        final String query = "insert into " + tableName +
                " (name, password, is_auth, user_role_id) values (?, ?, ?, ?);";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setBoolean(3, user.isAuthenticated());
            statement.setInt(4, user.getRole());
            statement.execute();
            logger.info("Execute addUser method");

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }
    }

    public void deleteUser(int userId) {

        final String query = "DELETE FROM " + tableName + " WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, userId);
            statement.executeUpdate();
            logger.info("Execute deleteUser update method");

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }

    }

    public List<User> filterUserByRole(int roleId) {

        final String query = "select * from " + tableName + " where user_role_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, roleId);
            ResultSet resultSet = statement.executeQuery();

            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setAuthenticated(resultSet.getBoolean("is_auth"));
                user.setRole(resultSet.getInt("user_role_id"));

                userList.add(user);
            }

            logger.info("Execute filterUserByRole method");
            return userList;

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }

        return new ArrayList<User>();
    }

    public User getUserById(int id) {

        final String query = "select * from " + tableName + " where id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            User user = new User();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setAuthenticated(resultSet.getBoolean("is_auth"));
                user.setRole(resultSet.getInt("user_role_id"));
            }

            logger.info("Execute getUserById method");
            return user;

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }

        return new User();
    }

    public List<User> getAllUsers() {

        final String query = "select * from " + tableName;

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet resultSet = statement.executeQuery();
            List<User> userList = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setAuthenticated(resultSet.getBoolean("is_auth"));
                user.setRole(resultSet.getInt("user_role_id"));

                userList.add(user);
            }

            logger.info("Execute getAllUsers method");
            return userList;

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }

        return new ArrayList<User>();
    }

    public void updateUserAuth(int userId, boolean isAuth) {

        final String query = "UPDATE " + tableName + " SET is_auth = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setBoolean(1, isAuth);
            statement.setInt(2, userId);
            statement.executeUpdate();
            logger.info("Execute updateUserAuth method");

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }
    }

}
