package com.allena.response;

import com.allena.model.LeasingContract;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@Data
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
}