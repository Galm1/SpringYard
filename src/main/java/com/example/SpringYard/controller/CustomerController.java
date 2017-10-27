package com.example.SpringYard.controller;

import com.example.SpringYard.model.Customer;
import com.example.SpringYard.service.CustomerService;
import com.example.SpringYard.service.CustomerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerServiceImpl;

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/api/customer")
    String getCustomers(Model model) {
        List<Customer> customers = customerServiceImpl.getAllCustomers();
        model.addAttribute("ListOfCustomers", customers);
        return "view_customers";
    }

    @PutMapping("/api/customer/{id}")
    public String updateCustomer(@PathVariable("id") Long id, @RequestBody String json) throws IOException {
        Customer customer = objectMapper.readValue(json, Customer.class);
        customer.setId(id);
        customerServiceImpl.updateCustomer(customer);
        return "ok";
    }

    @GetMapping("/api/customers")
    public String getAll(Model model) {
        model.addAttribute("customers", customerServiceImpl.getAllCustomers());
        return "ok";
    }


    @GetMapping("/api/customer/{id}")
    public String getCustomer(@PathVariable("id") Long id, Model model) {
      Customer customer = customerServiceImpl.findCustomerById(id);
      model.addAttribute("customer", customer);
      return "ok";
    }

    @RequestMapping("/api/add_customer")
    public String createCustomer(@RequestParam(value = "first_name") String firstName, @RequestParam(value = "last_name") String lastName, @RequestParam(value = "email") String email, @RequestParam(value = "phone") String phone, Model model) {
        Customer customer = new Customer();

        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPhone(phone);

        customerServiceImpl.addCustomer(customer);

        return "redirect:/customers";
    }

    @RequestMapping("/api/new_customer")
    public String newCustomer(Model model) {
        return "new_customer";
    }
}
