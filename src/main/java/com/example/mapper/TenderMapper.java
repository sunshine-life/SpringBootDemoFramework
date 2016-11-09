package com.example.mapper;

import com.example.domain.Tender;
import com.example.mybatismapper.MyMapper;

import java.util.List;

public interface TenderMapper extends MyMapper<Tender> {
    List<Tender> selectBycondition();
}