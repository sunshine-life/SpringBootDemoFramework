package com.example.mongo.controller;

import com.example.mongo.dao.Impl.FileDaoImpl;
import com.example.mongo.model.DemoInfo;
import com.example.mongo.service.MongoService;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

/**
 * Created by life on 16-11-3.
 */
@RestController
public class MongoFileController {
    @Autowired
    private FileDaoImpl fileDaoImpl;

    @RequestMapping("mongoSave")
    public String save(){
        File f = new File("/home/life/桌面/hehe.png");
        fileDaoImpl.SaveFile("files",f,null,"管钱",f.getName());
        return "success";
    }

    @RequestMapping("mongoDownload")
    public GridFSDBFile findByName(){
        GridFSDBFile temp = fileDaoImpl.retrieveFileOne("userlife.files","hehe");
        GridFSDBFile temp2 = fileDaoImpl.retrieveFileOne("files.files","hehe");
        System.out.println("臭傻逼");
        return null;
    }

}
