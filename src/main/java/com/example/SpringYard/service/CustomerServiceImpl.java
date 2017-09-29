package com.example.SpringYard.service;

import com.example.SpringYard.model.Customer;
import com.example.SpringYard.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }


    @Transactional
    public void updateCustomer(Long id, Customer customer) {
        customerRepository.save(customer);
    }

    public Customer findCustomerById(int id) {
        return customerRepository.findOne(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerRepository.delete(id);
    }

    @Override
    @Transactional
    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }
}
