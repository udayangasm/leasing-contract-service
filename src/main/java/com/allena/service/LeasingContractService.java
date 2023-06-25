package com.allena.service;

import com.allena.model.LeasingContract;
import com.allena.repository.LeasingContractRepository;
import com.allena.response.LeasingContractDto;
import org.springframework.stereotype.Service;
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
        return new LeasingContractDto(leasingContractRepository.save(leasingContract));
    }
}