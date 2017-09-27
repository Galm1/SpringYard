package com.example.SpringYard.repository;

import com.example.SpringYard.model.Customer;

import java.util.List;

public interface CustomerRepository {
    public void addCustomer(Customer customer);

    public void updateCustomer(int id, Customer customer);

    public Customer findCustomerById(Long id);

    public List<Customer> getAllCustomers();

    public void deleteCustomer(int id);
}

