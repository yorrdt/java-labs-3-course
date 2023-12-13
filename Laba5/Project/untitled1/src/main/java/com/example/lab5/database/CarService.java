package com.example.lab5.database;

import com.example.lab5.config.DatabaseConnection;
import com.example.lab5.model.Car;
import com.example.lab5.model.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarService {

    private final Logger logger = LoggerFactory.getLogger(CarService.class);
    private final String tableName = "cars";
    private final Connection connection = DatabaseConnection.getConnection();

    public void createTable() {

        final String query = "create table if not exists " + tableName + " " +
                "(id serial primary key, " +
                "name varchar(255) not null, " +
                "number varchar(255) not null, " +
                "car_state_id integer references car_states(id) on delete cascade" +
                ");";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            logger.info("Execute create " + tableName + " table");
        } catch (SQLException e) {
            // System.err.println("CarService" + e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }
    }

    public void addCar(String carName, String carNumber) {

        final String query = "insert into " + tableName + " (name, number, car_state_id) values (?, ?, ?);";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, carName);
            statement.setString(2, carNumber);
            statement.setInt(3, 0);
            statement.executeQuery();
            logger.info("Execute addCar method");

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }

    }

    public void deleteCar(int carId) {

        final String query = "DELETE FROM " + tableName + " WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, carId);
            statement.executeUpdate();
            logger.info("Execute deleteCar method");

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }

    }

    public void setCarState(Flight flight, int carState) {

        final String query = "UPDATE " + tableName + " SET car_state_id = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, carState);
            statement.setInt(2, flight.getCarId());
            statement.executeUpdate();
            logger.info("Execute setCarState method");

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }

    }

    public List<Car> getAllCars() {

        final String query = "select * from " + tableName;

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet resultSet = statement.executeQuery();
            List<Car> userList = new ArrayList<>();

            while (resultSet.next()) {
                Car car = new Car();

                car.setId(resultSet.getInt("id"));
                car.setName(resultSet.getString("name"));
                car.setNumber(resultSet.getString("number"));
                car.setCarStateId(resultSet.getInt("car_state_id"));

                userList.add(car);
            }

            logger.info("Execute getAllCars method");
            return userList;

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            logger.error("Error while execution " + e.getMessage());
        }

        return new ArrayList<Car>();
    }

}
