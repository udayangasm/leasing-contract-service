package com.allena.response;

import com.allena.model.Vehicle;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@Data
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
}