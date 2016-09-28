package com.example.mapper;

import java.util.List;

import com.example.domain.TestPOJO;

public interface TestMapper {
	
	public List<TestPOJO> get(Integer age);

	public void add();

}
