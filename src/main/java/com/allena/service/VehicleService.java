package com.allena.service;

import com.allena.model.Vehicle;
import com.allena.repository.VehicleRepository;
import com.allena.response.VehicleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleDto createOrUpdateVehicle(Vehicle vehicle) {
        return new VehicleDto(vehicleRepository.save(vehicle));
    }

    public List<VehicleDto> getAllVehicles() {
        return vehicleRepository.findAll().stream().map(VehicleDto::new).collect(Collectors.toList());
    }
}