package com.example.mongo.model.products;

import java.math.BigDecimal;
import java.util.Date;

public class Fund {
    private String fundManager;                     //基金经理
    private BigDecimal fundExtent;                  //基金规模
    private BigDecimal unitWorth;                   //单位净值(数字格式，保留4位小数)
    private BigDecimal oscillation;                 //净值单日变动值(数字格式，保留4位小数)
    private BigDecimal oscillationScale;            //净值单日变动率(如-0.15%，+0.15%)
    private String  hazardLevel;                    //风险等级
    private String CxLevel3;                        //晨星评级-三年
    private String CxLevel5;                        //晨星评级-三年
    private BigDecimal fluctuationScale;            //三年波动幅度%(数字格式，保留两位小数)
    private String fluctuationDesc;                 //三年波动评价
    private BigDecimal CxHazardScore;               //三年晨星风险系数（如20.88）
    private String CxHazardDesc;                    //三年晨星风险系数评价
    private BigDecimal XpScale;                     //夏普比率最近三年（如0.80）
    private String XpDesc;                          //夏普比率最近三年（如0.80）
    private String style;                           //股票投资风格箱(如大盘成长)
    private Date listing;                           //上市时间
    private String  exchange;                       //上市交易所


    public String getFundManager() {
        return fundManager;
    }

    public void setFundManager(String fundManager) {
        this.fundManager = fundManager;
    }

    public BigDecimal getFundExtent() {
        return fundExtent;
    }

    public void setFundExtent(BigDecimal fundExtent) {
        this.fundExtent = fundExtent;
    }

    public BigDecimal getUnitWorth() {
        return unitWorth;
    }

    public void setUnitWorth(BigDecimal unitWorth) {
        this.unitWorth = unitWorth;
    }

    public BigDecimal getOscillation() {
        return oscillation;
    }

    public void setOscillation(BigDecimal oscillation) {
        this.oscillation = oscillation;
    }

    public BigDecimal getOscillationScale() {
        return oscillationScale;
    }

    public void setOscillationScale(BigDecimal oscillationScale) {
        this.oscillationScale = oscillationScale;
    }

    public String getHazardLevel() {
        return hazardLevel;
    }

    public void setHazardLevel(String hazardLevel) {
        this.hazardLevel = hazardLevel;
    }

    public String getCxLevel3() {
        return CxLevel3;
    }

    public void setCxLevel3(String cxLevel3) {
        CxLevel3 = cxLevel3;
    }

    public String getCxLevel5() {
        return CxLevel5;
    }

    public void setCxLevel5(String cxLevel5) {
        CxLevel5 = cxLevel5;
    }

    public BigDecimal getFluctuationScale() {
        return fluctuationScale;
    }

    public void setFluctuationScale(BigDecimal fluctuationScale) {
        this.fluctuationScale = fluctuationScale;
    }

    public String getFluctuationDesc() {
        return fluctuationDesc;
    }

    public void setFluctuationDesc(String fluctuationDesc) {
        this.fluctuationDesc = fluctuationDesc;
    }

    public BigDecimal getCxHazardScore() {
        return CxHazardScore;
    }

    public void setCxHazardScore(BigDecimal cxHazardScore) {
        CxHazardScore = cxHazardScore;
    }

    public String getCxHazardDesc() {
        return CxHazardDesc;
    }

    public void setCxHazardDesc(String cxHazardDesc) {
        CxHazardDesc = cxHazardDesc;
    }

    public BigDecimal getXpScale() {
        return XpScale;
    }

    public void setXpScale(BigDecimal xpScale) {
        XpScale = xpScale;
    }

    public String getXpDesc() {
        return XpDesc;
    }

    public void setXpDesc(String xpDesc) {
        XpDesc = xpDesc;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Date getListing() {
        return listing;
    }

    public void setListing(Date listing) {
        this.listing = listing;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }
}
