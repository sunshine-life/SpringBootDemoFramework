package com.example.mongo.dao;

import com.mongodb.gridfs.GridFSDBFile;

import java.io.File;

/**
 * Created by life on 16-9-26.
 */
public interface FileDao {

    public void SaveFile(String collectionName, File file, String fileid, String companyid, String filename);

    public GridFSDBFile retrieveFileOne(String collectionName, String filename);
}
