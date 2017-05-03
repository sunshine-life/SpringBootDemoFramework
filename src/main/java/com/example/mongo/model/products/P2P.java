package com.example.mongo.model.products;

/**
 * Created by life on 16-11-18.
 */
public class P2P {
    private String  registMoney;                //注册资金
    private String P2pProtection;                 //资金保障
    private String VIPCost;                    //VIP费用
    private String issurerLevel;                   //平台评级
    private String issurerDesc;                    //平台背景
    private String prepareAmount;              //风险准备金
    private String trusteeShip;                    //资金托管

    public String getIssurerLevel() {
        return issurerLevel;
    }

    public void setIssurerLevel(String issurerLevel) {
        this.issurerLevel = issurerLevel;
    }

    public String getIssurerDesc() {
        return issurerDesc;
    }

    public void setIssurerDesc(String issurerDesc) {
        this.issurerDesc = issurerDesc;
    }

    public String getPrepareAmount() {
        return prepareAmount;
    }

    public void setPrepareAmount(String prepareAmount) {
        this.prepareAmount = prepareAmount;
    }

    public String getTrusteeShip() {
        return trusteeShip;
    }

    public void setTrusteeShip(String trusteeShip) {
        this.trusteeShip = trusteeShip;
    }

    public String getRegistMoney() {
        return registMoney;
    }

    public void setRegistMoney(String registMoney) {
        this.registMoney = registMoney;
    }

    public String getP2pProtection() {
        return P2pProtection;
    }

    public void setP2pProtection(String p2pProtection) {
        P2pProtection = p2pProtection;
    }

    public String getVIPCost() {
        return VIPCost;
    }

    public void setVIPCost(String VIPCost) {
        this.VIPCost = VIPCost;
    }


}
