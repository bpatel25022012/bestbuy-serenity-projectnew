package com.bestbuy.constants;

/**
 * Created By Bhavesh
 */
public class EndPoints {

    // end points for product
    public static final String GET_ALL_PRODUCTS = "/products";
    public static final String GET_SINGLE_PRODUCT_BY_ID = "/products/{id}";
    public static final String POST_A_PRODUCT = "/products/";
    public static final String UPDATE_PRODUCT_BY_ID = "/products/{id}";
    public static final String DELETE_PRODUCT_BY_ID = "/products/{id}";


   // end point for store
    public static final String FIND_ALL_STORES = "/stores";
    public static final String GET_SINGLE_STORES_BY_ID = "/stores/{id}";
    public static final String POST_A_STORES = "/stores";
    public static final String UPDATE_STORES_BY_ID = "/stores/{id}";
    public static final String DELETE_STORES_BY_ID = "/stores/{id}";

}
