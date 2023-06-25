package com.allena.service;

import com.allena.model.Customer;
import com.allena.repository.CustomerRepository;
import com.allena.response.CustomerDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDto createOrUpdateCustomer(Customer customer) {
        return new CustomerDto(customerRepository.save(customer));
    }

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream().map(CustomerDto::new).collect(Collectors.toList());
    }
}
