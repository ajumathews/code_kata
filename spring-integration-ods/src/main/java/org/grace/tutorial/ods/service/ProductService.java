package org.grace.tutorial.ods.service;

import org.grace.tutorial.ods.dao.ProductDAO;
import org.grace.tutorial.ods.mapper.ProductMapper;
import org.grace.tutorial.ods.model.Product;

public class ProductService {

    private ProductDAO productDao;

    private RabbitMQService rabbitMQService;

    private TransformService transformService;

    private ConsumeResourceService consumeResourceService;

    private ProductMapper productMapper;


    public void setProductDao(ProductDAO productDao) {
        this.productDao = productDao;
    }

    public void setRabbitMQService(RabbitMQService rabbitMQService) {
        this.rabbitMQService = rabbitMQService;
    }

    public void setTransformService(TransformService transformService) {
        this.transformService = transformService;
    }

    public void setConsumeResourceService(ConsumeResourceService consumeResourceService) {
        this.consumeResourceService = consumeResourceService;
    }

    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public void createProduct(String message){
        Product product = new Product(message);
        System.out.println("Product inserted to DB:" +product.getMessage());
    }

}
