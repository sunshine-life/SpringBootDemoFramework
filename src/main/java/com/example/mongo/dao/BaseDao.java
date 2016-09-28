package com.example.mongo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;


public abstract class BaseDao {
    @Autowired
    protected MongoTemplate template;

    @Autowired
    protected GridFsTemplate gridFsTemplate;
}
