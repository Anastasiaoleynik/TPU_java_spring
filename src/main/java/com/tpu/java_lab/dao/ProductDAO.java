package com.tpu.java_lab.dao;


import com.tpu.java_lab.model.Product;

interface ProductDAO {

    Product findByName(String name);

    /**
     * Check if provided product exists
     *
     * @param product product object
     * @return boolean
     */
    boolean checkIfProductExists(Product product);

}
