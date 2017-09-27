package com.example.SpringYard.service;

import com.example.SpringYard.model.Customer;
import com.example.SpringYard.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    @Override
    @Transactional
    public void updateCustomer(int id, Customer customer) {
        customerRepository.updateCustomer(id, customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer(id);
    }

}
