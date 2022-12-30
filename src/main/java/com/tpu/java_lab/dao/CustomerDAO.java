package com.tpu.java_lab.dao;


import com.tpu.java_lab.model.Customer;

interface CustomerDAO {

    Customer findByName(String name);

    boolean checkIfCustomerExists(String name);
}
