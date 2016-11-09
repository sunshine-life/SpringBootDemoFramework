package com.example.mongo.model;

import org.springframework.data.annotation.Id;

/**
 * Created by life on 16-11-4.
 */
public class ProductClick {
    //id属性是给mongodb用的，用@Id注解修饰
    @Id
    private String id;

    private String product;

    private int age;
}
