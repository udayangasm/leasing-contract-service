package com.allena.controller;

import com.allena.model.Customer;
import com.allena.response.CustomerDto;
import com.allena.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerDto createOrUpdateCustomer(@RequestBody Customer customer) {
        return customerService.createOrUpdateCustomer(customer);
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}