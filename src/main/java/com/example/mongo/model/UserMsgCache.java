package com.example.mongo.model;

import org.springframework.data.annotation.Id;


public class UserMsgCache {
    @Id
    private String id;

    private String cellphone;

    private String nationalId;

    private String paymentSourceNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPaymentSourceNo() {
        return paymentSourceNo;
    }

    public void setPaymentSourceNo(String paymentSourceNo) {
        this.paymentSourceNo = paymentSourceNo;
    }
}
