package com.allena.service;

import com.allena.model.LeasingContract;
import com.allena.repository.LeasingContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeasingContractService {

    @Autowired
    private LeasingContractRepository leasingContractRepository;


    public List<LeasingContract> getAllLeasingContracts(){
        return leasingContractRepository.findAll();
    }


    public LeasingContract getLeasingContractById(Long id){
        return leasingContractRepository.findById(id).orElse(null);
    }


    public LeasingContract createLeasingContract(LeasingContract leasingContract){
        return leasingContractRepository.save(leasingContract);
    }


    public LeasingContract updateLeasingContract(Long id, LeasingContract leasingContract){
        LeasingContract existingLeasingContract = leasingContractRepository.findById(id).orElse(null);
        existingLeasingContract.setContractNumber(leasingContract.getContractNumber());
        return leasingContractRepository.save(existingLeasingContract);
    }


    public void deleteLeasingContract(Long id){
        leasingContractRepository.deleteById(id);
    }


}