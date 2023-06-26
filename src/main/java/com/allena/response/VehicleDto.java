package com.allena.response;

import com.allena.model.Vehicle;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class VehicleDto {

    private Long id;
    private String brand;
    private String model;
    private int modelYear;
    private String vehicleIdentificationNumber;
    private Double price;

    public VehicleDto(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.modelYear = vehicle.getModelYear();
        this.vehicleIdentificationNumber = vehicle.getVehicleIdentificationNumber();
        this.price = vehicle.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}