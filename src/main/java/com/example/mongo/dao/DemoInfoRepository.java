package com.example.mongo.dao;

import com.example.mongo.model.DemoInfo;


public interface DemoInfoRepository {
    DemoInfo findByName(String name);
}
