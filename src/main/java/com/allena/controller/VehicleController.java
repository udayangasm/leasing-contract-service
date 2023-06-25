package com.allena.controller;

import com.allena.model.Vehicle;
import com.allena.response.VehicleDto;
import com.allena.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public VehicleDto createOrUpdateVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createOrUpdateVehicle(vehicle);
    }

    @GetMapping
    public List<VehicleDto> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }
}