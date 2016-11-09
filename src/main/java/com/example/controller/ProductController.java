package com.example.controller;

import com.example.BuilderT.factory.ProductService;
import com.example.BuilderT.product.CurrentA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by life on 16-10-26.
 */
@RestController
public class ProductController {

    protected static Logger logger= LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private CurrentA currentA;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/getProducts")
    public String show(){
        System.out.println( currentA.getProduct());
        System.out.println(productService.createCurrent().toString());
        return productService.createCurrent().toString();
    }
}
