package com.example.SpringYard.service;

import com.example.SpringYard.common.CustomerUtils;
import com.example.SpringYard.model.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.example.SpringYard.common.CustomerUtils.createTestPerson;
import static com.example.SpringYard.common.CustomerUtils.findInList;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void testAddGet() {
        String firstName = Long.toString(System.currentTimeMillis());
        String lastName = Long.toString(System.currentTimeMillis());

        Customer customer1 = new Customer();
        customer1.setFirstName(firstName);
        customer1.setLastName(lastName);
        customerService.addCustomer(customer1);

        List<Customer> customers = customerService.getAllCustomers();

        Customer customer2 = findInList(customers, firstName, lastName);
        Assert.assertNotNull(customer2);

        Customer customer3 = customerService.findCustomerById(customer2.getId());
        Assert.assertNotNull(customer3);
        Assert.assertEquals(firstName, customer3.getFirstName());
        Assert.assertEquals(lastName, customer3.getLastName());
    }








    //    @Test
//    public void addCustomer() throws Exception {
//    }
//
//    @Test
//    public void updateCustomer() throws Exception {
//    }
//
//    @Test
//    public void findCustomerById() throws Exception {
//    }
//
//    @Test
//    public void getAllCustomers() throws Exception {
//    }
//
//    @Test
//    public void deleteCustomer() throws Exception {
//    }

}