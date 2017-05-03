package com.example.mongo.model.groups;

import java.math.BigDecimal;

/**
 * Created by life on 16-11-30.
 */
public class Overview {

    private BigDecimal  max_return;                             //最高收益
    private BigDecimal  min_return;                             //最低收益
    private BigDecimal  bank_expected_rtn;                      //银行预期收益
    private BigDecimal  max_return_proba;                       //达到最高收益的概率
    private BigDecimal  min_return_proba;                       //达到最低收益的概率
    private BigDecimal  fund_stop_high;                         //基金止涨点
    private BigDecimal  fund_stop_low;                          //基金止损失
    private BigDecimal  expected_return;                        //预期收益
    private BigDecimal  expected_retrun_proba;                  //预期收益实现概率
    private Money_alloc money_alloc;
    private Weight      weight;
    private Expected_return_details  expected_return_details;

    public BigDecimal getMax_return() {
        return max_return;
    }

    public void setMax_return(BigDecimal max_return) {
        this.max_return = max_return;
    }

    public BigDecimal getMin_return() {
        return min_return;
    }

    public void setMin_return(BigDecimal min_return) {
        this.min_return = min_return;
    }

    public BigDecimal getBank_expected_rtn() {
        return bank_expected_rtn;
    }

    public void setBank_expected_rtn(BigDecimal bank_expected_rtn) {
        this.bank_expected_rtn = bank_expected_rtn;
    }

    public BigDecimal getMax_return_proba() {
        return max_return_proba;
    }

    public void setMax_return_proba(BigDecimal max_return_proba) {
        this.max_return_proba = max_return_proba;
    }

    public BigDecimal getMin_return_proba() {
        return min_return_proba;
    }

    public void setMin_return_proba(BigDecimal min_return_proba) {
        this.min_return_proba = min_return_proba;
    }

    public BigDecimal getFund_stop_high() {
        return fund_stop_high;
    }

    public void setFund_stop_high(BigDecimal fund_stop_high) {
        this.fund_stop_high = fund_stop_high;
    }

    public BigDecimal getFund_stop_low() {
        return fund_stop_low;
    }

    public void setFund_stop_low(BigDecimal fund_stop_low) {
        this.fund_stop_low = fund_stop_low;
    }

    public BigDecimal getExpected_return() {
        return expected_return;
    }

    public void setExpected_return(BigDecimal expected_return) {
        this.expected_return = expected_return;
    }

    public BigDecimal getExpected_retrun_proba() {
        return expected_retrun_proba;
    }

    public void setExpected_retrun_proba(BigDecimal expected_retrun_proba) {
        this.expected_retrun_proba = expected_retrun_proba;
    }

    public Money_alloc getMoney_alloc() {
        return money_alloc;
    }

    public void setMoney_alloc(Money_alloc money_alloc) {
        this.money_alloc = money_alloc;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public Expected_return_details getExpected_return_details() {
        return expected_return_details;
    }

    public void setExpected_return_details(Expected_return_details expected_return_details) {
        this.expected_return_details = expected_return_details;
    }

    /**
     * 投资金额分布
     */
    public class Money_alloc{
        private BigDecimal  fund;
        private BigDecimal  p2p;
        private BigDecimal  bank;

        public BigDecimal getFund() {
            return fund;
        }

        public void setFund(BigDecimal fund) {
            this.fund = fund;
        }

        public BigDecimal getP2p() {
            return p2p;
        }

        public void setP2p(BigDecimal p2p) {
            this.p2p = p2p;
        }

        public BigDecimal getBank() {
            return bank;
        }

        public void setBank(BigDecimal bank) {
            this.bank = bank;
        }
    }
    /**
     * 各部分权重
     */
    public class Weight{
        private BigDecimal  fund;
        private BigDecimal  p2p;
        private BigDecimal  bank;
        public BigDecimal getFund() {
            return fund;
        }

        public void setFund(BigDecimal fund) {
            this.fund = fund;
        }

        public BigDecimal getP2p() {
            return p2p;
        }

        public void setP2p(BigDecimal p2p) {
            this.p2p = p2p;
        }

        public BigDecimal getBank() {
            return bank;
        }

        public void setBank(BigDecimal bank) {
            this.bank = bank;
        }
    }
    /**
     * 各类产品预期收益
     */
    public class Expected_return_details{
        private BigDecimal  fund;
        private BigDecimal  p2p;
        private BigDecimal  bank;
        public BigDecimal getFund() {
            return fund;
        }

        public void setFund(BigDecimal fund) {
            this.fund = fund;
        }

        public BigDecimal getP2p() {
            return p2p;
        }

        public void setP2p(BigDecimal p2p) {
            this.p2p = p2p;
        }

        public BigDecimal getBank() {
            return bank;
        }

        public void setBank(BigDecimal bank) {
            this.bank = bank;
        }
    }

    @Override
    public String toString() {
        return "Overview{" +
                "max_return=" + max_return +
                ", min_return=" + min_return +
                ", bank_expected_rtn=" + bank_expected_rtn +
                ", max_return_proba=" + max_return_proba +
                ", min_return_proba=" + min_return_proba +
                ", fund_stop_high=" + fund_stop_high +
                ", fund_stop_low=" + fund_stop_low +
                ", expected_return=" + expected_return +
                ", expected_retrun_proba=" + expected_retrun_proba +
                ", money_alloc=" + money_alloc +
                ", weight=" + weight +
                ", expected_return_details=" + expected_return_details +
                '}';
    }
}
