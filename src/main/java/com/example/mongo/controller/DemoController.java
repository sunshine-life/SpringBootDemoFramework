package com.example.mongo.controller;

import java.util.List;

import com.example.mongo.model.DemoInfo;
import com.example.mongo.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private MongoService mongoService;

    @RequestMapping("save")
    public String save(){
        mongoService.save();
        return "ok";
    }

    @RequestMapping("find")
    public List<DemoInfo> find(){
        return mongoService.find();
    }

    @RequestMapping("findByName")
    public DemoInfo findByName(){
        return mongoService.findByName("张三");
    }

}
