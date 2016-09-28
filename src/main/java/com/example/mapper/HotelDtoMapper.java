package com.example.mapper;

import java.util.List;

import com.example.dto.HotelDto;

public interface HotelDtoMapper {
	
	public List<HotelDto> findByCountry(String country);
}
