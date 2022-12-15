package org.grace.tutorial.ods.service;

import org.grace.tutorial.ods.model.Product;

public class ProductService {

    public void createProduct(String message){
        Product product = new Product(message);
        System.out.println("Product inserted to DB:" +product.getMessage());
    }

}
