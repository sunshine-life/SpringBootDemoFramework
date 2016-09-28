package com.example.mongo.dao;

import com.example.mongo.model.DemoInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 继承自MongoRepository接口，MongoRepository接口包含了常用的CRUD操作，
 * 例如：save、insert、findall等等。我们可以定义自己的查找接口，
 * 例如根据demoInfo的name搜索，具体的DemoInfoRepository接口代码如下：
 */
public interface DemoInfoRepositoryDao extends MongoRepository<DemoInfo, String>, DemoInfoRepository{
    DemoInfo findByName(String name);
}
