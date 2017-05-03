package com.example.mongo.model.products;

import org.mongodb.morphia.annotations.Indexed;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 所有产品统一字段
 */
public class Products  implements Comparable {
    @Id
    private String id;
    @Indexed
    private Long proNum;                                    //产品编号（基金为基金编号，银行、P2P为爬虫网站定义的编号）
    private Date timestamp;                                 //添加产品时间
    private Date updateTime;                                //更新产品时间
    private String name;                                    //产品名称
    private String issuer;                                  //发行平台
    private String issuerUrl;                               //平台网址
    private String issuerDesc;                              //平台介绍
    private String investType;                              //投资类型
    private BigDecimal excepteYield;                        //预期收益率
    private Integer investDays;                             //投资期限
    private String repaymentWay;                            //还款方式
    private String rechargeCost;                        //充值费用
    private String withdrawCost;                        //取现费用
    private String currency;                                //委托币种
    private BigDecimal investMin;                           //起投金额
    private BigDecimal totalAmount;                         //总额度
    private BigDecimal leftAmount;                          //剩余额度
    private BigDecimal incrementAmount;                     //递增单位
    private Date startDt;                                   //发行起始日期
    private Date endDt;                                     //发行终止日期
    private Date earningStartDt;                            //收益起始日期
    private Date earningEndDt;                              //收益终止日期
    private String proDesc;                                 //产品介绍
    private BigDecimal selledAmount;                        //已售额度
    private BigDecimal integrateScore;                      //综合评分
    private String  Remarks;                                //备注
    private Boolean  isProduct;                             //是否添加到产品库
    private String  ManagerCost;                        //管理费用
    private String issuerLocation;                          //平台所在地区
    private Date issuerDate;                                //机构成立日期
    private String urlToBuy;                                //购买网址
    private String imgSrc;                                  //图片来源
    private String annotation;                              //产品批注
    private Fund fund;
    private Bank bank;
    private P2P p2p;

    public String getUrlToBuy() {
        return urlToBuy;
    }

    public void setUrlToBuy(String urlToBuy) {
        this.urlToBuy = urlToBuy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getProNum() {
        return proNum;
    }

    public void setProNum(Long proNum) {
        this.proNum = proNum;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getIssuerUrl() {
        return issuerUrl;
    }

    public void setIssuerUrl(String issuerUrl) {
        this.issuerUrl = issuerUrl;
    }

    public String getIssuerDesc() {
        return issuerDesc;
    }

    public void setIssuerDesc(String issuerDesc) {
        this.issuerDesc = issuerDesc;
    }

    public String getInvestType() {
        return investType;
    }

    public void setInvestType(String investType) {
        this.investType = investType;
    }

    public BigDecimal getExcepteYield() {
        return excepteYield;
    }

    public void setExcepteYield(BigDecimal excepteYield) {
        this.excepteYield = excepteYield;
    }

    public Integer getInvestDays() {
        return investDays;
    }

    public void setInvestDays(Integer investDays) {
        this.investDays = investDays;
    }

    public String getRepaymentWay() {
        return repaymentWay;
    }

    public void setRepaymentWay(String repaymentWay) {
        this.repaymentWay = repaymentWay;
    }

    public String getRechargeCost() {
        return rechargeCost;
    }

    public void setRechargeCost(String rechargeCost) {
        this.rechargeCost = rechargeCost;
    }

    public String getWithdrawCost() {
        return withdrawCost;
    }

    public void setWithdrawCost(String withdrawCost) {
        this.withdrawCost = withdrawCost;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getInvestMin() {
        return investMin;
    }

    public void setInvestMin(BigDecimal investMin) {
        this.investMin = investMin;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getLeftAmount() {
        return leftAmount;
    }

    public void setLeftAmount(BigDecimal leftAmount) {
        this.leftAmount = leftAmount;
    }

    public BigDecimal getIncrementAmount() {
        return incrementAmount;
    }

    public void setIncrementAmount(BigDecimal incrementAmount) {
        this.incrementAmount = incrementAmount;
    }

    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    public Date getEndDt() {
        return endDt;
    }

    public void setEndDt(Date endDt) {
        this.endDt = endDt;
    }

    public Date getEarningStartDt() {
        return earningStartDt;
    }

    public void setEarningStartDt(Date earningStartDt) {
        this.earningStartDt = earningStartDt;
    }

    public Date getEarningEndDt() {
        return earningEndDt;
    }

    public void setEarningEndDt(Date earningEndDt) {
        this.earningEndDt = earningEndDt;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }


    public BigDecimal getSelledAmount() {
        return selledAmount;
    }

    public void setSelledAmount(BigDecimal selledAmount) {
        this.selledAmount = selledAmount;
    }

    public BigDecimal getIntegrateScore() {
        return integrateScore;
    }

    public void setIntegrateScore(BigDecimal integrateScore) {
        this.integrateScore = integrateScore;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public Boolean getProduct() {
        return isProduct;
    }

    public void setProduct(Boolean product) {
        isProduct = product;
    }

    public String getManagerCost() {
        return ManagerCost;
    }

    public void setManagerCost(String managerCost) {
        ManagerCost = managerCost;
    }

    public String getIssuerLocation() {
        return issuerLocation;
    }

    public void setIssuerLocation(String issuerLocation) {
        this.issuerLocation = issuerLocation;
    }

    public Date getIssuerDate() {
        return issuerDate;
    }

    public void setIssuerDate(Date issuerDate) {
        this.issuerDate = issuerDate;
    }

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public P2P getP2p() {
        return p2p;
    }

    public void setP2p(P2P p2p) {
        this.p2p = p2p;
    }


    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }


    @Override
    public int compareTo(Object o) {
        Products temo = (Products) o;
        return this.getIntegrateScore().compareTo(temo.getIntegrateScore());
    }

    @Override
    public String toString() {
        return "Products{" +
                "id='" + id + '\'' +
                ", proNum=" + proNum +
                ", timestamp=" + timestamp +
                ", updateTime=" + updateTime +
                ", name='" + name + '\'' +
                ", issuer='" + issuer + '\'' +
                ", issuerUrl='" + issuerUrl + '\'' +
                ", issuerDesc='" + issuerDesc + '\'' +
                ", investType='" + investType + '\'' +
                ", excepteYield=" + excepteYield +
                ", investDays=" + investDays +
                ", repaymentWay='" + repaymentWay + '\'' +
                ", rechargeCost='" + rechargeCost + '\'' +
                ", withdrawCost='" + withdrawCost + '\'' +
                ", currency='" + currency + '\'' +
                ", investMin=" + investMin +
                ", totalAmount=" + totalAmount +
                ", leftAmount=" + leftAmount +
                ", incrementAmount=" + incrementAmount +
                ", startDt=" + startDt +
                ", endDt=" + endDt +
                ", earningStartDt=" + earningStartDt +
                ", earningEndDt=" + earningEndDt +
                ", proDesc='" + proDesc + '\'' +
                ", selledAmount=" + selledAmount +
                ", integrateScore=" + integrateScore +
                ", Remarks='" + Remarks + '\'' +
                ", isProduct=" + isProduct +
                ", ManagerCost='" + ManagerCost + '\'' +
                ", issuerLocation='" + issuerLocation + '\'' +
                ", issuerDate=" + issuerDate +
                ", urlToBuy='" + urlToBuy + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", annotation='" + annotation + '\'' +
                ", fund=" + fund +
                ", bank=" + bank +
                ", p2p=" + p2p +
                '}';
    }
}