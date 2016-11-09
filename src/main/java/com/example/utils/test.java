package com.example.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by life on 16-11-8.
 */
public class test {
    public static void main(String[] args) {
        BigDecimal redPaperAmount=new BigDecimal("100.11");
        redPaperAmount = new BigDecimal("100100").multiply(new BigDecimal("0.002")).setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(redPaperAmount);
        List<BigDecimal> reds = new ArrayList<>();
        if(redPaperAmount.compareTo(new BigDecimal("200"))<1){
            reds.add(redPaperAmount);
        }
        while(redPaperAmount.compareTo(new BigDecimal("200"))==1){
            reds.add(new BigDecimal("200"));
            redPaperAmount = redPaperAmount.subtract(new BigDecimal("200"));
            if(redPaperAmount.compareTo(new BigDecimal("200"))<1){
                reds.add(redPaperAmount);
            }
            System.out.println(redPaperAmount.toString());
        }
        System.out.println(reds.toString());
    }
}
