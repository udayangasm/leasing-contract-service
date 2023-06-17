package com.allena.controller;

import com.allena.model.LeasingContract;
import com.allena.service.LeasingContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leasing-contracts")
public class LeasingContractController{

    @Autowired
    private LeasingContractService leasingContractService;


    @GetMapping
    public List<LeasingContract> getAllLeasingContracts(){
        return leasingContractService.getAllLeasingContracts();
    }

    @GetMapping("/{id}")
    public LeasingContract getLeasingContractById(@PathVariable("id") Long id){
        return leasingContractService.getLeasingContractById(id);
    }

    @PostMapping
    public LeasingContract createLeasingContract(@RequestBody LeasingContract leasingContract){
        return leasingContractService.createLeasingContract(leasingContract);
    }

    @PutMapping("/{id}")
    public LeasingContract updateLeasingContract(@PathVariable("id") Long id, @RequestBody LeasingContract leasingContract){
        return leasingContractService.updateLeasingContract(id, leasingContract);
    }

    @DeleteMapping("/{id}")
    public void deleteLeasingContract(@PathVariable("id") Long id){
        leasingContractService.deleteLeasingContract(id);
    }

}

