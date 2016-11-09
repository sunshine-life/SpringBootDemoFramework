package com.example.mongo.dao.Impl;

import com.example.mongo.dao.BaseDao;
import com.example.mongo.dao.DemoInfoRepository;
import com.example.mongo.dao.FileDao;
import com.example.mongo.model.DemoInfo;
import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by life on 16-9-26.
 */
@Component
public class FileDaoImpl extends BaseDao implements FileDao {

    /**
     * 存储文件
     * @param collectionName 集合名
     * @param file 文件
     * @param fileid 文件id
     * @param companyid 文件的公司id
     * @param filename 文件名称
     */
    public void SaveFile(String collectionName, File file, String fileid, String companyid, String filename) {
        try {
            DB db = template.getDb();
            // 存储fs的根节点
            GridFS gridFS = new GridFS(db, collectionName);
            GridFSInputFile gfs = gridFS.createFile(new FileInputStream(file));
            gfs.put("collectionName", "files");
            gfs.put("aliases", companyid);
            gfs.put("filename", fileid);
            gfs.put("contentType", filename.substring(filename.lastIndexOf(".")));
            gfs.save();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("存储文件时发生错误！！！");
        }
    }

    // 取出文件
    public GridFSDBFile retrieveFileOne(String collectionName, String filename) {
        try {
            DB db = template.getDb();
            // 获取fs的根节点
            GridFS gridFS = new GridFS(db, collectionName);
            GridFSDBFile dbfile = gridFS.findOne(filename);
            if (dbfile != null) {
                return dbfile;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }


    /*public static void main(String[] args) {
        long start = new Date().getTime();
        try {
            ServerAddress serverAddress = new ServerAddress("127.0.0.1",27017);
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();
            addrs.add(serverAddress);
            MongoCredential credential = MongoCredential.createMongoCRCredential("guanqian", "guanqian", "gq2016".toCharArray());
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            credentials.add(credential);
            //通过连接认证获取MongoDB连接
            MongoClient mongoClient = new MongoClient(addrs,credentials);
            //连接到数据库
            DB mydb = mongoClient.getDB("guanqian");

            File f = new File("/home/life/桌面/2016-09-22-120538_819x489_scrot.png");
            System.out.println(f.getAbsoluteFile());
            GridFS myFS = new GridFS(mydb,"userlife");
            GridFSInputFile inputFile = myFS.createFile(new FileInputStream(f));
            inputFile.save();
            DBCursor cursor = myFS.getFileList();
            while(cursor.hasNext()){
                System.out.println(cursor.next());
            }
            mongoClient.close();
            long endTime = new Date().getTime();

            System.out.println((endTime - start));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
