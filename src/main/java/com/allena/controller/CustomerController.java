package com.allena.controller;

import com.allena.model.Customer;
import com.allena.response.CustomerDto;
import com.allena.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerDto createOrUpdateCustomer(@RequestBody Customer customer) {
        logger.info("Creating or updating customer: {}", customer);
        return customerService.createOrUpdateCustomer(customer);
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers() {
        logger.info("Getting all customers");
        return customerService.getAllCustomers();
    }
}