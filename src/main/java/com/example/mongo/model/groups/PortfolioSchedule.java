package com.example.mongo.model.groups;


import java.math.BigDecimal;
import java.util.ArrayList;

public class PortfolioSchedule {
    private ArrayList<P2PDetails> p2p_details;
    private int day;
    private BigDecimal  p2p_prop;
    private BigDecimal  bank_money;
    private BigDecimal  fund_prop;
    private BigDecimal  bank_prop;
    private BigDecimal  p2p_money;
    private BigDecimal  fund_money;
    private BigDecimal  money;

    public class P2PDetails{
        private int cur_period;
        private BigDecimal  money;
        private BigDecimal  pro_num;
        private BigDecimal  prop;

        public int getCur_period() {
            return cur_period;
        }

        public void setCur_period(int cur_period) {
            this.cur_period = cur_period;
        }

        public BigDecimal getMoney() {
            return money;
        }

        public void setMoney(BigDecimal money) {
            this.money = money;
        }

        public BigDecimal getPro_num() {
            return pro_num;
        }

        public void setPro_num(BigDecimal pro_num) {
            this.pro_num = pro_num;
        }

        public BigDecimal getProp() {
            return prop;
        }

        public void setProp(BigDecimal prop) {
            this.prop = prop;
        }
    }

    public ArrayList<P2PDetails> getP2p_details() {
        return p2p_details;
    }

    public void setP2p_details(ArrayList<P2PDetails> p2p_details) {
        this.p2p_details = p2p_details;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public BigDecimal getP2p_prop() {
        return p2p_prop;
    }

    public void setP2p_prop(BigDecimal p2p_prop) {
        this.p2p_prop = p2p_prop;
    }

    public BigDecimal getBank_money() {
        return bank_money;
    }

    public void setBank_money(BigDecimal bank_money) {
        this.bank_money = bank_money;
    }

    public BigDecimal getFund_prop() {
        return fund_prop;
    }

    public void setFund_prop(BigDecimal fund_prop) {
        this.fund_prop = fund_prop;
    }

    public BigDecimal getBank_prop() {
        return bank_prop;
    }

    public void setBank_prop(BigDecimal bank_prop) {
        this.bank_prop = bank_prop;
    }

    public BigDecimal getP2p_money() {
        return p2p_money;
    }

    public void setP2p_money(BigDecimal p2p_money) {
        this.p2p_money = p2p_money;
    }

    public BigDecimal getFund_money() {
        return fund_money;
    }

    public void setFund_money(BigDecimal fund_money) {
        this.fund_money = fund_money;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "PortfolioSchedule{" +
                "p2p_details=" + p2p_details +
                ", day=" + day +
                ", p2p_prop=" + p2p_prop +
                ", bank_money=" + bank_money +
                ", fund_prop=" + fund_prop +
                ", bank_prop=" + bank_prop +
                ", p2p_money=" + p2p_money +
                ", fund_money=" + fund_money +
                ", money=" + money +
                '}';
    }
}
