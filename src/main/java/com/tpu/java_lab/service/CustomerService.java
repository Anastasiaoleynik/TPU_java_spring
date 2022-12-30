package com.tpu.java_lab.service;

import com.tpu.java_lab.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer findById(Integer id);

    void saveCustomer(Customer customer);

    Customer findByName(String name);

    void updateCustomer(Customer customer);

    void deleteCustomerById(Integer id);

    List<Customer> findAllCustomers();

    boolean checkIfCustomerExists(String name);

}