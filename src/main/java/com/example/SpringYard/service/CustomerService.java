package com.example.SpringYard.service;

import com.example.SpringYard.model.Customer;

import java.util.List;

public interface CustomerService {
    public void addCustomer(Customer customer);

    public void updateCustomer(int id, Customer customer);

    public Customer findCustomerById(int id);

    public List<Customer> getAllCustomers();

    public void deleteCustomer(int id);

}
