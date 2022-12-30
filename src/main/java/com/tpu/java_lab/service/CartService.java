package com.tpu.java_lab.service;

import com.tpu.java_lab.model.Cart;

import java.util.List;

public interface CartService {

    Cart findById(Integer id);

    void saveCart(Cart cart);

    void updateCart(Cart cart);

    void deleteCartById(Integer id);

    void addProduct(Integer cartId, Integer productId);

    List<Cart> findAllCarts();

    Cart findByCustomerId(Integer id);

}