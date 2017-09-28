package com.example.SpringYard.service;

import com.example.SpringYard.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer addCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public Customer findCustomerById(Long id);

    public List<Customer> getAllCustomers();

    public void deleteCustomer(int id);

}
