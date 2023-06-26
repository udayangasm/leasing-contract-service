package com.allena.controller;

import com.allena.model.LeasingContract;
import com.allena.response.ContractOverviewDto;
import com.allena.response.LeasingContractDto;
import com.allena.service.LeasingContractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leasing-contracts")
public class LeasingContractController {

    private static final Logger logger = LoggerFactory.getLogger(LeasingContractController.class);
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
        logger.info("Creating or updating leasing contract: {}", leasingContract);
        return leasingContractService.createOrUpdateLeasingContract(leasingContract);
    }

    @GetMapping("/{id}")
    public LeasingContractDto getLeasingContract(@PathVariable Long id) {
        logger.info("Getting leasing contract with id: {}", id);
        return leasingContractService.getLeasingContract(id);
    }

    @GetMapping("/overview")
    public List<ContractOverviewDto> getAllLeasingContractOverview() {
        logger.info("Getting leasing contract overview");
        return leasingContractService.getAllLeasingContractOverview();
    }
}