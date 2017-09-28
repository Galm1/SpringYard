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
    public Customer addCustomer(Customer customer) {
        return (Customer) customerRepository.save(customer);
    }

    @Override
    @Transactional
    public void updateCustomer(int id, Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerById(Long id) {
        return (Customer) customerRepository.findOne(id);
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

}
