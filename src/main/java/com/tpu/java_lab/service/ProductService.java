package com.tpu.java_lab.service;

import com.tpu.java_lab.model.Product;

import java.util.List;

public interface ProductService {

    Product findById(Integer id);

    Product findByName(String name);

    void saveProduct(Product product);

    void updateProduct(Product product);

    void deleteProductById(Integer id);

    List<Product> findAllProducts();

    boolean checkIfProductExists(Product product);

}