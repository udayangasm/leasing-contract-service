package com.allena.service;

import com.allena.exception.CustomerException;
import com.allena.exception.LeasingContractException;
import com.allena.exception.VehicleException;
import com.allena.model.Customer;
import com.allena.model.LeasingContract;
import com.allena.model.Vehicle;
import com.allena.repository.LeasingContractRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LeasingContractServiceTest {

    @InjectMocks
    LeasingContractService leasingContractService;

    @Mock
    LeasingContractRepository leasingContractRepository;

    @Test
    public void adding_new_leasing_contract_successfully() {
        //Arrange
        LeasingContract leasingContract = getLeasingContract();
        when(leasingContractRepository.save(any())).thenReturn(leasingContract);
        //Act
        //Assert
        assertDoesNotThrow( () -> leasingContractService.createOrUpdateLeasingContract(leasingContract));
    }

    @Test
    public void updating_new_leasing_contract_successfully() {
        //Arrange
        LeasingContract leasingContract = getLeasingContract();
        leasingContract.setId(1L);
        when(leasingContractRepository.existsById(any())).thenReturn(true);
        when(leasingContractRepository.save(any())).thenReturn(leasingContract);
        //Act
        //Assert
        assertDoesNotThrow( () -> leasingContractService.createOrUpdateLeasingContract(leasingContract));
    }

    @Test
    public void Throw_error_when_contract_number_is_not_found() {
        //Arrange
        LeasingContract leasingContract = getLeasingContract();
        leasingContract.setContractNumber(null);
        //Act
        //Assert
        assertThrows(LeasingContractException.class, () -> leasingContractService.createOrUpdateLeasingContract(leasingContract));
    }

    @Test
    public void Throw_error_when_contract_number_is_empty() {
        //Arrange
        LeasingContract leasingContract = getLeasingContract();
        leasingContract.setContractNumber("");
        //Act
        //Assert
        assertThrows(LeasingContractException.class, () -> leasingContractService.createOrUpdateLeasingContract(leasingContract));
    }

    @Test
    public void Throw_error_when_contract_number_is_already_exist() {
        //Arrange
        LeasingContract leasingContract = getLeasingContract();
        when(leasingContractRepository.existsByContractNumber(any())).thenReturn(true);
        //Act
        //Assert
        assertThrows(LeasingContractException.class, () -> leasingContractService.createOrUpdateLeasingContract(leasingContract));
    }

    @Test
    public void Throw_error_when_contract_is_not_found_when_update_operation() {
        //Arrange
        LeasingContract leasingContract = getLeasingContract();
        leasingContract.setId(1L);
        when(leasingContractRepository.existsById(any())).thenReturn(false);
        //Act
        //Assert
        assertThrows(LeasingContractException.class, () -> leasingContractService.createOrUpdateLeasingContract(leasingContract));
    }

    @Test
    public void Throw_error_when_monthly_rate_is_less_than_or_equal_zero() {
        //Arrange
        LeasingContract leasingContract = getLeasingContract();
        leasingContract.setMonthlyRate(0.0);
        //Act
        //Assert
        assertThrows(LeasingContractException.class, () -> leasingContractService.createOrUpdateLeasingContract(leasingContract));
    }

    @Test
    public void Throw_error_when_customer_not_found() {
        //Arrange
        LeasingContract leasingContract = getLeasingContract();
        leasingContract.setCustomer(null);
        //Act
        //Assert
        assertThrows(CustomerException.class, () -> leasingContractService.createOrUpdateLeasingContract(leasingContract));
    }

    @Test
    public void Throw_error_when_vehicle_not_found() {
        //Arrange
        LeasingContract leasingContract = getLeasingContract();
        leasingContract.setVehicle(null);
        //Act
        //Assert
        assertThrows(VehicleException.class, () -> leasingContractService.createOrUpdateLeasingContract(leasingContract));
    }

    @Test
    public void Throw_error_when_vehicle_is_already_has_a_contract() {
        //Arrange
        LeasingContract leasingContract = getLeasingContract();
        when(leasingContractRepository.existsByVehicleId(any())).thenReturn(true);
        //Act
        //Assert
        assertThrows(VehicleException.class, () -> leasingContractService.createOrUpdateLeasingContract(leasingContract));
    }

    private LeasingContract getLeasingContract(){

        LeasingContract leasingContract = new LeasingContract();
        leasingContract.setContractNumber("123");
        leasingContract.setMonthlyRate(50.0);

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setDateOfBirth(LocalDate.of(1990, 1, 1));
        leasingContract.setCustomer(customer);

        Vehicle vehicle = new Vehicle();
        vehicle.setBrand("BMW");
        vehicle.setModel("X5");
        vehicle.setModelYear(2019);
        vehicle.setPrice(100000.0);
        leasingContract.setVehicle(vehicle);

        return leasingContract;
    }
}