package com.example.lab5.database;

import com.example.lab5.config.DatabaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleService {

    private final Logger logger = LoggerFactory.getLogger(RoleService.class);
    private final String tableName = "user_roles";
    private final Connection connection = DatabaseConnection.getConnection();

    public void createTable() {

        try {

            Statement statement = connection.createStatement();

            String sql = "create table if not exists " + tableName + " " +
                    "(id serial primary key, " +
                    "user_role varchar(255) not null" +
                    ");";

            statement.execute(sql);
            logger.info("Execute create " + tableName + " table");

        } catch (SQLException e) {
            // System.err.println("RoleService: " + e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }
    }

    public void setTableRoles() {

        try {

            Statement statement = connection.createStatement();

            statement.addBatch("insert into " + tableName + " (id, user_role) values (0, 'Admin'); ");
            statement.addBatch("insert into " + tableName + " (id, user_role) values (1, 'Manager'); ");
            statement.addBatch("insert into " + tableName + " (id, user_role) values (2, 'User'); ");

            statement.executeBatch();
            logger.info("Execute setTableRoles method");

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }
    }
}
