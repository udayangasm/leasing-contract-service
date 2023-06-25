package com.allena.controller;

import com.allena.model.LeasingContract;
import com.allena.response.LeasingContractDto;
import com.allena.service.LeasingContractService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leasing-contracts")
public class LeasingContractController {

    private LeasingContractService leasingContractService;

    public LeasingContractController(LeasingContractService leasingContractService) {
        this.leasingContractService = leasingContractService;
    }

    @GetMapping
    public List<LeasingContractDto> getAllLeasingContracts() {
        return leasingContractService.getAllLeasingContracts();
    }

    @PostMapping
    public LeasingContractDto createOrUpdateLeasingContract(@RequestBody LeasingContract leasingContract) {
        return leasingContractService.createOrUpdateLeasingContract(leasingContract);
    }
}