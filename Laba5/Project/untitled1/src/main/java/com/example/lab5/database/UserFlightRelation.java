package com.example.lab5.database;

import com.example.lab5.config.DatabaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserFlightRelation {

    private final Logger logger = LoggerFactory.getLogger(UserFlightRelation.class);
    private final String tableName = "user_flight_relation";
    private final Connection connection = DatabaseConnection.getConnection();

    public void createTable() {

        final String query = "create table if not exists " + tableName + " " +
                "(id serial primary key, " +
                "user_id integer references users(id) on delete cascade, " +
                "flight_id integer references flights(id) on delete cascade " +
                ");";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            logger.info("Execute create " + tableName + " table");
        } catch (SQLException e) {
            // System.err.println("UserFlightRelation: " + e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }
    }

    public void addUserFlightRelation(int userId, int flightId) {

        final String query = "insert into " + tableName + " (user_id, flight_id) values (?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, flightId);

            preparedStatement.execute();
            logger.info("Execute addUserFlightRelation");

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }
    }
}
