package com.tpu.java_lab.service;

import com.tpu.java_lab.dao.ProductDAOImpl;
import com.tpu.java_lab.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    private final ProductDAOImpl productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAOImpl productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public Product findById(Integer id) {
        return productDAO.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return productDAO.findByName(name);
    }

    @Override
    public void saveProduct(Product product) {
        productDAO.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.update(product);
    }

    @Override
    public void deleteProductById(Integer id) {
        productDAO.deleteById(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }

    @Override
    public boolean checkIfProductExists(Product product) {
        return productDAO.checkIfProductExists(product);
    }
}
