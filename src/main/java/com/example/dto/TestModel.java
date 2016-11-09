package com.example.dto;

/**
 * Created by life on 16-10-14.
 */
public class TestModel {
    public String money;
    public String expected_return;
    public String min_return;
    public String time;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getExpected_return() {
        return expected_return;
    }

    public void setExpected_return(String expected_return) {
        this.expected_return = expected_return;
    }

    public String getMin_return() {
        return min_return;
    }

    public void setMin_return(String min_return) {
        this.min_return = min_return;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "money='" + money + '\'' +
                ", expected_return='" + expected_return + '\'' +
                ", min_return='" + min_return + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
