package com.example.mongo.dao.Impl;

import com.example.mongo.dao.BaseDao;
import com.example.mongo.dao.DemoInfoRepository;
import com.example.mongo.model.DemoInfo;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class DemoInfoRepositoryDaoImpl extends BaseDao implements DemoInfoRepository {

    @Override
    public DemoInfo findByName(String name) {
        Criteria criatira = new Criteria();
        criatira.andOperator(Criteria.where("name").is("张三"));
        template.find(new Query(criatira), DemoInfo.class);
        return template.find(new Query(criatira), DemoInfo.class).get(0);
    }
}
