package com.example.SpringYard.controller;

import com.example.SpringYard.model.Customer;
import com.example.SpringYard.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.PublicKey;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/api/customer")
    public String addCustomer(@RequestBody String json) throws IOException {
        Customer customer = objectMapper.readValue(json, Customer.class);
        customerService.addCustomer(customer);
        return "ok";
    }
}
