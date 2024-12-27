package com.santji.service;

import java.util.List;

import com.santji.entity.Hotel;

import lombok.Getter;

public interface HotelService {

	//create
	Hotel createHotel(Hotel hotel);
	//get all hotel
	List<Hotel> getHotelsList();
	
	//get hotel by id
	Hotel getHotelById(String hotelId);
	
	String deleteHotelByhotelId(String hotelId);
	
}
