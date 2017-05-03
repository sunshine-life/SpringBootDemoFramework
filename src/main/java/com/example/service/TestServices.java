package com.example.service;

import com.example.domain.Tender;
import com.example.domain.TestPOJO;
import com.example.mapper.TenderMapper;
import com.example.mastermapper.MasterMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        System.out.println("fuck!!!!!!!!!!!!!!");
        Integer page = 1;
        Integer pageSize = 6;
        if(page!= null && pageSize!= null){
            PageHelper.startPage(page, pageSize);
        }
        for(Tender t:tenderMapper.selectBycondition()){
            System.out.println(t.toString());
        }
        return tenderMapper.selectBycondition();
    }
}
