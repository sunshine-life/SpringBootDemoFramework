package com.example.mongo.service;

import com.example.mongo.dao.DemoInfoRepositoryDao;
import com.example.mongo.model.DemoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoService {
    @Autowired
    private DemoInfoRepositoryDao demoInfoRepository;

    public String save(){
        DemoInfo demoInfo = new DemoInfo();
        demoInfo.setName("张三");
        demoInfo.setAge(20);
        demoInfoRepository.save(demoInfo);

        demoInfo = new DemoInfo();
        demoInfo.setName("李四");
        demoInfo.setAge(30);
        demoInfoRepository.save(demoInfo);
        return "ok";
    }

    public List<DemoInfo> find(){
        return demoInfoRepository.findAll();
    }

    public DemoInfo findByName(String name){
        System.out.println(demoInfoRepository.findByName(name).toString());
        return demoInfoRepository.findByName(name);
    }
}
