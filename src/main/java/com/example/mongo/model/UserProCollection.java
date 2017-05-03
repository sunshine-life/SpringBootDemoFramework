package com.example.mongo.model;


import org.mongodb.morphia.annotations.Indexed;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.HashMap;

public class UserProCollection {
    @Id
    private String id;
    @Indexed
    private Long userId;

    private HashMap<Long,Date> proNum;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<Long, Date> getProNum() {
        return proNum;
    }

    public void setProNum(HashMap<Long, Date> proNum) {
        this.proNum = proNum;
    }

    @Override
    public String toString() {
        return "UserProCollection{" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                ", proNum=" + proNum +
                '}';
    }
}
