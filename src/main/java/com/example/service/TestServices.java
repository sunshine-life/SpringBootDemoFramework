package com.example.service;

import java.util.List;


import com.example.domain.Tender;
import com.example.mapper.TenderMapper;
import com.example.mastermapper.MasterMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.TestPOJO;
import com.example.dto.HotelDto;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServices {

    @Autowired
    private MasterMapper masterMapper;

    @Autowired
    private TenderMapper tenderMapper;
	
	public String show(){
        return "hello world!";
    }

    public List<TestPOJO> showDao(int age){
        System.out.println("开始查询");
        Integer page = 1;
        Integer pageSize = 3;
        if(page!= null && pageSize!= null){
            PageHelper.startPage(page, pageSize);
        }
        for(Tender t:tenderMapper.selectBycondition()){
            System.out.println(t.toString());
        }
        return null;
    }
    public List<Tender> selectBycondition(){
        Integer page = 1;
        Integer pageSize = 3;
        if(page!= null && pageSize!= null){
            PageHelper.startPage(page, pageSize);
        }
        return tenderMapper.selectBycondition();
    }
}
