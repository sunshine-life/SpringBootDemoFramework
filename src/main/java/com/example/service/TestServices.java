package com.example.service;

import java.util.List;


import com.example.mastermapper.MasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.TestPOJO;
import com.example.dto.HotelDto;
import com.example.mapper.HotelDtoMapper;
import com.example.mapper.TestMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServices {

	@Autowired
    private TestMapper testMapper;

    @Autowired
    private MasterMapper masterMapper;

    @Autowired
    private HotelDtoMapper hotelDtoMapper;
	
	public String show(){
        return "hello world!";
    }

    public List<TestPOJO> showDao(int age){
        return testMapper.get(age);
    }

    @Transactional
    public void testTransaction(){
        masterMapper.add();
        String s = "test";
        System.out.println(Integer.parseInt(s));
        testMapper.add();
    }

    public List<TestPOJO> showDaoMaster(int age){
        return masterMapper.get(age);
    }
    
    public List<HotelDto> findByCountry(String country){
        return hotelDtoMapper.findByCountry(country);
    }
    
}
