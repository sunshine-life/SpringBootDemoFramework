package com.example.mongo.model.groups;


import java.math.BigDecimal;
import java.util.List;

public class PurchaseDetails {

    private List<proDetails> fund;
    private List<proDetails> p2p;
    private List<proDetails> bank;

    public class proDetails{
        private int duration;
        private int purchase_time;
        private BigDecimal money;
        private int period;
        private long pro_num;
        private BigDecimal annual_interest;
        private String pro_name;
        private BigDecimal ratio;

        public BigDecimal getRatio() {
            return ratio;
        }

        public void setRatio(BigDecimal ratio) {
            this.ratio = ratio;
        }

        public BigDecimal getAnnual_interest() {
            return annual_interest;
        }

        public void setAnnual_interest(BigDecimal annual_interest) {
            this.annual_interest = annual_interest;
        }

        public String getPro_name() {
            return pro_name;
        }

        public void setPro_name(String pro_name) {
            this.pro_name = pro_name;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getPurchase_time() {
            return purchase_time;
        }

        public void setPurchase_time(int purchase_time) {
            this.purchase_time = purchase_time;
        }

        public BigDecimal getMoney() {
            return money;
        }

        public void setMoney(BigDecimal money) {
            this.money = money;
        }

        public int getPeriod() {
            return period;
        }

        public void setPeriod(int period) {
            this.period = period;
        }

        public long getPro_num() {
            return pro_num;
        }

        public void setPro_num(long pro_num) {
            this.pro_num = pro_num;
        }
    }

    public List<proDetails> getFund() {
        return fund;
    }

    public void setFund(List<proDetails> fund) {
        this.fund = fund;
    }

    public List<proDetails> getP2p() {
        return p2p;
    }

    public void setP2p(List<proDetails> p2p) {
        this.p2p = p2p;
    }

    public List<proDetails> getBank() {
        return bank;
    }

    public void setBank(List<proDetails> bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "PurchaseDetails{" +
                "fund=" + fund +
                ", p2p=" + p2p +
                ", bank=" + bank +
                '}';
    }
}
