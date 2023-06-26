package com.allena.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ContractOverviewDto {

    private String contractNumber;
    private String customerName;
    private String vehicleDetails;
    private String vin;
    private String monthlyRate;
    private String vehiclePrice;
    private Long contractDetailsId;

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(String monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    public String getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(String vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public Long getContractDetailsId() {
        return contractDetailsId;
    }

    public void setContractDetailsId(Long contractDetailsId) {
        this.contractDetailsId = contractDetailsId;
    }
}
