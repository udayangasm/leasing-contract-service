package com.allena.response;

import com.allena.model.LeasingContract;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LeasingContractDto {

    private Long id;
    private String contractNumber;
    private double monthlyRate;
    private CustomerDto customer;
    private VehicleDto vehicle;

    public LeasingContractDto(LeasingContract leasingContract) {
        this.id = leasingContract.getId();
        this.contractNumber = leasingContract.getContractNumber();
        this.monthlyRate = leasingContract.getMonthlyRate();
        this.customer = new CustomerDto(leasingContract.getCustomer());
        this.vehicle = new VehicleDto(leasingContract.getVehicle());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(double monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }
}