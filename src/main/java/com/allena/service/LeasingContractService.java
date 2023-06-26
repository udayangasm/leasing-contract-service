package com.allena.service;

import com.allena.exception.CustomerException;
import com.allena.exception.LeasingContractException;
import com.allena.exception.VehicleException;
import com.allena.model.LeasingContract;
import com.allena.repository.LeasingContractRepository;
import com.allena.response.ContractOverviewDto;
import com.allena.response.LeasingContractDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeasingContractService {

    private final LeasingContractRepository leasingContractRepository;

    public LeasingContractService(LeasingContractRepository leasingContractRepository) {
        this.leasingContractRepository = leasingContractRepository;
    }

    public List<LeasingContractDto> getAllLeasingContracts() {
        return leasingContractRepository.findAll().stream().map(LeasingContractDto::new).collect(Collectors.toList());
    }

    public LeasingContractDto createOrUpdateLeasingContract(LeasingContract leasingContract) {
        validateLeasingContract(leasingContract);
        return new LeasingContractDto(leasingContractRepository.save(leasingContract));
    }

    private void validateLeasingContract(LeasingContract leasingContract) {

        if (leasingContract.getId() != null && leasingContract.getId() > 0) {

            if (!leasingContractRepository.existsById(leasingContract.getId())) {
                throw new LeasingContractException("Leasing contract not found");
            }

        } else {

            if (leasingContract.getContractNumber() == null || leasingContract.getContractNumber().trim().isEmpty()) {
                throw new LeasingContractException("Contract number is required");
            } else {
                if (leasingContractRepository.existsByContractNumber(leasingContract.getContractNumber())) {
                    throw new LeasingContractException("Contract number already exists");
                }
            }

            if (leasingContract.getMonthlyRate() <= 0) {
                throw new LeasingContractException("Monthly rate is required");
            }

            if (leasingContract.getCustomer() == null) {
                throw new CustomerException("Customer is required");
            }

            if (leasingContract.getVehicle() == null) {
                throw new VehicleException("Vehicle is required");
            } else {
                if (leasingContractRepository.existsByVehicleId(leasingContract.getVehicle().getId())) {
                    throw new VehicleException("Vehicle is already leased");
                }
            }
        }
    }

    public LeasingContractDto getLeasingContract(Long id) {
        return new LeasingContractDto(leasingContractRepository.findById(id).orElseThrow(() -> new RuntimeException("Leasing contract not found")));
    }

    public List<ContractOverviewDto> getAllLeasingContractOverview() {

        List<LeasingContractDto> allLeasingContracts = getAllLeasingContracts();
        List<ContractOverviewDto> contractOverviewDtoList = new ArrayList<>();

        allLeasingContracts.forEach(leasingContractDto -> {
            ContractOverviewDto contractOverviewDto = new ContractOverviewDto();
            contractOverviewDto.setContractNumber(leasingContractDto.getContractNumber());
            contractOverviewDto.setCustomerName(leasingContractDto.getCustomer().getFirstName() + " " + leasingContractDto.getCustomer().getLastName());
            contractOverviewDto.setVehicleDetails(leasingContractDto.getVehicle().getBrand() + " " + leasingContractDto.getVehicle().getModel() + " (" + leasingContractDto.getVehicle().getModelYear() + ")");

            if (leasingContractDto.getVehicle().getVehicleIdentificationNumber().isEmpty()) {
                contractOverviewDto.setVin("-");
            } else contractOverviewDto.setVin(leasingContractDto.getVehicle().getVehicleIdentificationNumber());

            contractOverviewDto.setMonthlyRate(String.format("%.2f", leasingContractDto.getMonthlyRate()) + " €");
            contractOverviewDto.setVehiclePrice(String.format("%.2f", leasingContractDto.getVehicle().getPrice()) + " €");
            contractOverviewDto.setContractDetailsId(leasingContractDto.getId());

            contractOverviewDtoList.add(contractOverviewDto);
        });

        return contractOverviewDtoList;
    }
}