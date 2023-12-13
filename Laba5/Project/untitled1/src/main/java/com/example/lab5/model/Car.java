package com.example.lab5.model;

public class Car {
    private int id;
    private String name;
    private String number;
    private int carStateId;

    public Car() {}

    public Car(int id, String name, String number, int carStateId) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.carStateId = carStateId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCarStateId(int carStateId) {
        this.carStateId = carStateId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getCarStateId() {
        return carStateId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", carStateId=" + carStateId +
                '}';
    }
}
