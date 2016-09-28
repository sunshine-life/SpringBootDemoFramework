package com.example.controller;

import com.example.Application;
import com.example.domain.TestPOJO;
import org.example.OrgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.TestServices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    protected static Logger logger= LoggerFactory.getLogger(com.example.controller.TestController.class);

    @Autowired
    private Environment env;

    @Autowired
    private TestServices testServices;


    @RequestMapping(value = "/show2")
    public String show(){
        return testServices.show();
    }

    @RequestMapping(value = "/showDao2")
    public Object showDao(){
        List<TestPOJO> list = testServices.showDao(13);
        List<TestPOJO> list2 = testServices.showDaoMaster(13);
        Map<String,List> map = new HashMap<>();
        map.put("从数据库",list);
        map.put("主数据库",list2);
        //不处理异常时将会出发例外通知
        testServices.testTransaction();

       /* try{
            testServices.testTransaction();
        }catch(Exception e){
            logger.info("===============================事务出现异常，抛出！=======================");
            new WebException("事务出现异常，抛出！");
        }*/
        return map;

    }


    @RequestMapping(value = "/country/{country}")
    public Object showDao(@PathVariable String country){
        return testServices.findByCountry(country);
    }

    @RequestMapping(value = "/test")
    public String getTest(){
        return env.getProperty("db");
    }

}
