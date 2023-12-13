package com.example.lab5.database;

import com.example.lab5.config.DatabaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CarStateService {

    private final Logger logger = LoggerFactory.getLogger(CarStateService.class);
    private final String tableName = "car_states";
    private final Connection connection = DatabaseConnection.getConnection();

    public void createTable() {

        final String query = "create table if not exists " + tableName + " " +
                "(id serial primary key, " +
                "state varchar(255) not null" +
                ");";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            logger.info("Execute create " + tableName + " table");
        } catch (SQLException e) {
            // System.err.println("CarStateService: " + e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }
    }

    public void setTableStates() {

        try {

            Statement statement = connection.createStatement();

            statement.addBatch("insert into " + tableName + " (id, state) values (0, 'Нормальное'); ");
            statement.addBatch("insert into " + tableName + " (id, state) values (1, 'Среднее'); ");
            statement.addBatch("insert into " + tableName + " (id, state) values (2, 'Критическое'); ");

            statement.executeBatch();

            logger.info("Execute setTableStates for " + tableName + " method");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
