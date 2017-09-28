package com.example.SpringYard.controller;

import com.example.SpringYard.model.Customer;
import com.example.SpringYard.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.PublicKey;
import java.util.List;

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

    @PutMapping("/api/customer/{id}")
    public String updateCustomer(@PathVariable("id") Long id, @RequestBody String json) throws IOException {
        Customer customer = objectMapper.readValue(json, Customer.class);
        customer.setId(id);
        customerService.updateCustomer(customer);
        return "ok";
    }

    @GetMapping("/api/customers")
    public List<Customer> getAll(Model model) {
        return customerService.getAllCustomers();
    }

    @GetMapping("/api/customer/{id}")
    public Customer getCustomer(@PathVariable("id") Long id) {
        return (Customer) customerService.findCustomerById(id);
    }


}
