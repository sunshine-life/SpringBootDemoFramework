package com.example.mongo.model.products;

import java.math.BigDecimal;


public class Bank {
    private BigDecimal excepteYield;                    //到期收益率
    private BigDecimal entrustedMaDay;                 //委托管理期（数字格式，保留两位小数，单位：月）
    private BigDecimal payYieldCyclel;                  //付息周期（数字格式，保留两位小数，单位：月）
    private Boolean isPreservation;                     //是否保本
    private Boolean isPledge;                           //可否质押
    private String  comparisonDesc;                     //同期存款利率比较
    private String  suitableArea;                       //适用地区
    private String  bankNature;                         //银行性质
    private String  yieldType;                          //收益类型

    public String getBankNature() {
        return bankNature;
    }

    public void setBankNature(String bankNature) {
        this.bankNature = bankNature;
    }

    public String getYieldType() {
        return yieldType;
    }

    public void setYieldType(String yieldType) {
        this.yieldType = yieldType;
    }

    public String getSuitableArea() {
        return suitableArea;
    }

    public void setSuitableArea(String suitableArea) {
        this.suitableArea = suitableArea;
    }

    public BigDecimal getExcepteYield() {
        return excepteYield;
    }

    public void setExcepteYield(BigDecimal excepteYield) {
        this.excepteYield = excepteYield;
    }

    public BigDecimal getEntrustedMaDay() {
        return entrustedMaDay;
    }

    public void setEntrustedMaDay(BigDecimal entrustedMaDay) {
        this.entrustedMaDay = entrustedMaDay;
    }

    public BigDecimal getPayYieldCyclel() {
        return payYieldCyclel;
    }

    public void setPayYieldCyclel(BigDecimal payYieldCyclel) {
        this.payYieldCyclel = payYieldCyclel;
    }

    public Boolean getPreservation() {
        return isPreservation;
    }

    public void setPreservation(Boolean preservation) {
        isPreservation = preservation;
    }

    public Boolean getPledge() {
        return isPledge;
    }

    public void setPledge(Boolean pledge) {
        isPledge = pledge;
    }

    public String getComparisonDesc() {
        return comparisonDesc;
    }

    public void setComparisonDesc(String comparisonDesc) {
        this.comparisonDesc = comparisonDesc;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "excepteYield=" + excepteYield +
                ", entrustedMaDay=" + entrustedMaDay +
                ", payYieldCyclel=" + payYieldCyclel +
                ", isPreservation=" + isPreservation +
                ", isPledge=" + isPledge +
                ", comparisonDesc='" + comparisonDesc + '\'' +
                '}';
    }
}
