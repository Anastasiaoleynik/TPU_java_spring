package com.tpu.java_lab.dao;


import com.tpu.java_lab.model.Cart;

interface CartDAO {

    Cart findByCustomerId(Integer id);

    /**
     * Add product to cart
     *
     * @param cartId    - id of cart to add product to
     * @param productId - id of product to add to provided cart
     */
    void addProduct(Integer cartId, Integer productId);
}
