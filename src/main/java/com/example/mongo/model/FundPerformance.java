package com.example.mongo.model;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

import java.math.BigDecimal;

public class FundPerformance {

    @Id
    private ObjectId id;

    @Indexed
    private Long proNum;                    //基金编号

    private String time;                    //时间区间

    private BigDecimal responseRate;        //总回报

    private BigDecimal fundExponent;        //基金指数

    private BigDecimal similarAve;          //同类平均

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Long getProNum() {
        return proNum;
    }

    public void setProNum(Long proNum) {
        this.proNum = proNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BigDecimal getResponseRate() {
        return responseRate;
    }

    public void setResponseRate(BigDecimal responseRate) {
        this.responseRate = responseRate;
    }

    public BigDecimal getFundExponent() {
        return fundExponent;
    }

    public void setFundExponent(BigDecimal fundExponent) {
        this.fundExponent = fundExponent;
    }

    public BigDecimal getSimilarAve() {
        return similarAve;
    }

    public void setSimilarAve(BigDecimal similarAve) {
        this.similarAve = similarAve;
    }
}
