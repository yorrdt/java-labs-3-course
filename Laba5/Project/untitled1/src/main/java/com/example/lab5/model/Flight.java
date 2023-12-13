package com.example.lab5.model;

public class Flight {
    private int id;
    private int userId;
    private String comingFrom;
    private String arriveIn;
    private boolean isCompleted;
    private int carId;
    private String carName;
    private String carNumber;

    public Flight() {}

    public Flight(int id, String comingFrom, String arriveIn, boolean isCompleted) {
        this.id = id;
        this.comingFrom = comingFrom;
        this.arriveIn = arriveIn;
        this.isCompleted = isCompleted;
    }

    public Flight(int id, int userId, String comingFrom, String arriveIn, boolean isCompleted, String carName, String carNumber) {
        this.id = id;
        this.userId = userId;
        this.comingFrom = comingFrom;
        this.arriveIn = arriveIn;
        this.isCompleted = isCompleted;
        this.carName = carName;
        this.carNumber = carNumber;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCarId() {
        return carId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public int getUserId() {
        return userId;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComingFrom(String comingFrom) {
        this.comingFrom = comingFrom;
    }

    public void setArriveIn(String arriveIn) {
        this.arriveIn = arriveIn;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getId() {
        return id;
    }

    public String getComingFrom() {
        return comingFrom;
    }

    public String getArriveIn() {
        return arriveIn;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", comingFrom='" + comingFrom + '\'' +
                ", arriveIn='" + arriveIn + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
