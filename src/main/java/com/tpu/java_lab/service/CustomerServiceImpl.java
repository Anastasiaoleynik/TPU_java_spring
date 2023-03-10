package com.tpu.java_lab.service;

import com.tpu.java_lab.dao.CustomerDAOImpl;
import com.tpu.java_lab.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAOImpl customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAOImpl customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer findById(Integer id) {
        return customerDAO.findById(id);
    }

    @Override
    public Customer findByName(String name) {
        return customerDAO.findByName(name);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDAO.update(customer);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerDAO.deleteById(id);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerDAO.findAll();
    }

    @Override
    public boolean checkIfCustomerExists(String name) {
        return customerDAO.checkIfCustomerExists(name);
    }

}
