package com.example.SpringYard.controller;

import com.example.SpringYard.model.Customer;
import com.example.SpringYard.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    public String getAll(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "ok";
    }


    @GetMapping("/api/customer/{id}")
    public String getCustomer(@PathVariable("id") Long id, Model model) {
      Customer customer = customerService.findCustomerById(id);
      model.addAttribute("customer", customer);
      return "ok";
    }
}
