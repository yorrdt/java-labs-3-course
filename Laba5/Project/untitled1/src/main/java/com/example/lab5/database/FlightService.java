package com.example.lab5.database;

import com.example.lab5.config.DatabaseConnection;
import com.example.lab5.model.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightService {

    private final Logger logger = LoggerFactory.getLogger(FlightService.class);
    private final String tableName = "flights";
    private final Connection connection = DatabaseConnection.getConnection();

    public void createTable() {

        final String query = "create table if not exists " + tableName + " " +
                "(id serial primary key, " +
                "coming_from varchar(255) not null, " +
                "arrive_in varchar(255) not null, " +
                "is_completed boolean not null, " +
                "car_id integer references cars(id) on delete cascade" +
                ");";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            logger.info("Execute create " + tableName + " table");
        } catch (SQLException e) {
            // System.err.println("FlightService: " + e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }
    }

    public Flight getFlightById(int id) {

        final String query = "select * from " + tableName + " where id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            Flight flight = new Flight();

            if (resultSet.next()) {
                flight.setId(resultSet.getInt("id"));
                flight.setComingFrom(resultSet.getString("coming_from"));
                flight.setArriveIn(resultSet.getString("arrive_in"));
                flight.setCompleted(resultSet.getBoolean("is_completed"));
                flight.setCarId(resultSet.getInt("car_id"));
            }

            logger.info("Execute getFlightById method");
            return flight;

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }

        return new Flight();
    }


    public void addFlight(int userId, Flight flight, int carId) {
        final String query = "insert into " + tableName +
                " (coming_from, arrive_in, is_completed, car_id) values (?, ?, ?, ?);";

        try {

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, flight.getComingFrom());
            statement.setString(2, flight.getArriveIn());
            statement.setBoolean(3, flight.isCompleted());
            statement.setInt(4, carId);
            statement.execute();

            logger.info("Execute addFlight method, insert info in " + tableName);

            final int lastFlightId = getLastFlightId();
            if (lastFlightId == 0) {
                throw new Exception();
            }

            UserFlightRelation userFlightRelation = new UserFlightRelation();
            userFlightRelation.addUserFlightRelation(userId, lastFlightId);

            logger.info("Execute getFlightById method, addUserFlightRelation");

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Последний рейс имеет id 0");
        }
    }

    public void deleteFlight(int flightId) {

        final String query = "DELETE FROM " + tableName + " WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, flightId);
            statement.executeUpdate();
            logger.info("Execute deleteFlight method");

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }

    }

    public void completeFlight(int flightComplete) {

        final String query = "UPDATE " + tableName + " SET is_completed = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setBoolean(1, true);
            statement.setInt(2, flightComplete);
            statement.executeUpdate();
            logger.info("Execute completeFlight method, update " + tableName);

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }
    }

    private int getLastFlightId() {
        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT id from flights ORDER BY id DESC LIMIT 1");

            if (resultSet.next()) {
                logger.info("Execute getLastFlightId method");
                return resultSet.getInt("id");
            }

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }
        return 0;
    }

    public List<Flight> getAllFlights() {

        final String query = "select user_flight_relation.user_id, " +
                "flights.id, " +
                "flights.coming_from, " +
                "flights.arrive_in, " +
                "flights.is_completed, " +
                "flights.car_id, " +
                "cars.name, " +
                "cars.number " +
                "from flights " +
                "right join cars on flights.car_id = cars.id " +
                "right join user_flight_relation on user_flight_relation.flight_id = flights.id;";

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<Flight> flightList = new ArrayList<Flight>();
            while (resultSet.next()) {
                Flight flight = new Flight();

                flight.setUserId(resultSet.getInt("user_id"));
                flight.setId(resultSet.getInt("id"));
                flight.setComingFrom(resultSet.getString("coming_from"));
                flight.setArriveIn(resultSet.getString("arrive_in"));
                flight.setCompleted(resultSet.getBoolean("is_completed"));
                flight.setCarId(resultSet.getInt("car_id"));
                flight.setCarName(resultSet.getString("name"));
                flight.setCarNumber(resultSet.getString("number"));

                flightList.add(flight);
            }

            logger.info("Execute getAllFlights method, return flightsList");
            return flightList;

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }

        return new ArrayList<Flight>();
    }

    public List<Flight> getAllFlightsForDriver(int driverId) {
        final String query = "select user_flight_relation.user_id, " +
                "flights.id, " +
                "flights.coming_from, " +
                "flights.arrive_in, " +
                "flights.is_completed, " +
                "cars.name, " +
                "cars.number " +
                "from flights " +
                "right join cars on flights.car_id = cars.id " +
                "right join user_flight_relation on user_flight_relation.flight_id = flights.id " +
                "where user_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, driverId);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Flight> flightList = new ArrayList<Flight>();
            while (resultSet.next()) {
                Flight flight = new Flight();

                flight.setUserId(resultSet.getInt("user_id"));
                flight.setId(resultSet.getInt("id"));
                flight.setComingFrom(resultSet.getString("coming_from"));
                flight.setArriveIn(resultSet.getString("arrive_in"));
                flight.setCompleted(resultSet.getBoolean("is_completed"));
                flight.setCarName(resultSet.getString("name"));
                flight.setCarNumber(resultSet.getString("number"));

                flightList.add(flight);
            }

            logger.info("Execute getAllFlightsForDriver method, return flightsList for driver");
            return flightList;

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }

        return new ArrayList<Flight>();
    }

}
