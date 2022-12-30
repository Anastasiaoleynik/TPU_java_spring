package com.tpu.java_lab.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * The type Product metamodel.
 */
@StaticMetamodel(Product.class)
public class Customer_ {

    /**
     * The constant id.
     */
    public static volatile SingularAttribute<Customer, Integer> id;
    /**
     * The constant name.
     */
    public static volatile SingularAttribute<Customer, String> name;
    /**
     * The constant cart.
     */
    public static volatile SingularAttribute<Customer, Cart> cart;
}