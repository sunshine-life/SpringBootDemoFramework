package com.example.dto;

import java.util.Date;

/**
 * Created by life on 16-10-14.
 */
public class TestProtestData {
    private Date startDate;
    private Date endDate;
    public TestProtestData(){}
    public TestProtestData(Date startDate,Date endDate){
        if(startDate.compareTo(endDate)>0){
            throw new IllegalArgumentException("数据有误");
        }
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    @Override
    public String toString() {
        return "TestProtestData{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public static void main(String[] args) {
        Date start = new Date();
        System.out.println(start);
        Date end = new Date();
        System.out.println(end);
        TestProtestData test =  new TestProtestData(start,end);
        System.out.println(test.toString());
        end.setYear(78);
        System.out.println("=====================");
        System.out.println(end);
        System.out.println(test.toString());

    }
}
