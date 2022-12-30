package com.tpu.java_lab.controller;

import com.tpu.java_lab.model.Cart;
import com.tpu.java_lab.model.Customer;
import com.tpu.java_lab.model.Product;
import com.tpu.java_lab.service.CartServiceImpl;
import com.tpu.java_lab.service.CustomerServiceImpl;
import com.tpu.java_lab.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.PersistenceException;

@RestController
public class CartRestController {

    private final CartServiceImpl cartService;
    private final CustomerServiceImpl customerService;
    private final ProductServiceImpl productService;

    @Autowired
    public CartRestController(CartServiceImpl cartService, CustomerServiceImpl customerService,
            ProductServiceImpl productService) {
        this.cartService = cartService;
        this.customerService = customerService;
        this.productService = productService;
    }

    /**
     * Add product to cart
     *
     * @param cartId    ID of cart
     * @param productId ID of product to add
     */
    @RequestMapping(value = "/api/shop/cart/{cartId}/add/{productId}", method = RequestMethod.POST)
    public ResponseEntity<Void> addProductToCart(@PathVariable("cartId") int cartId,
            @PathVariable("productId") int productId) {
        try {
            Product product = productService.findById(productId);
            Cart cart = cartService.findById(cartId);

            if (product == null || cart == null) {
                return new ResponseEntity<>(
                        HttpStatus.NOT_FOUND);
            }

            cartService.addProduct(cartId, productId);
        } catch (PersistenceException e) {
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Create cart for provided customer
     *
     * @param customerId ID of customer to create cart for
     */
    @RequestMapping(value = "/api/shop/cart/customer/{customerId}", method = RequestMethod.POST)
    public ResponseEntity<Void> createCart(@PathVariable("customerId") int customerId) {
        try {
            Customer customer = customerService.findById(customerId);

            if (customer == null) {
                return new ResponseEntity<>(
                        HttpStatus.NOT_FOUND);
            } else {
                Cart cart = new Cart();
                cart.setCustomer(customer);
                cartService.saveCart(cart);
            }
        } catch (PersistenceException e) {
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
