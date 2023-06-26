package com.allena.controller;

import com.allena.model.Vehicle;
import com.allena.response.VehicleDto;
import com.allena.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public VehicleDto createOrUpdateVehicle(@RequestBody Vehicle vehicle) {
        logger.info("Creating or updating vehicle: {}", vehicle);
        return vehicleService.createOrUpdateVehicle(vehicle);
    }

    @GetMapping
    public List<VehicleDto> getAllVehicles() {
        logger.info("Getting all vehicles");
        return vehicleService.getAllVehicles();
    }
}