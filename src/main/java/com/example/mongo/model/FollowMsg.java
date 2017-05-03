package com.example.mongo.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;


public class FollowMsg {
    @Id
    private ObjectId id;
    private String msg;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
