package com.santji.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santji.entity.Hotel;
import com.santji.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
	
		String string = UUID.randomUUID().toString();
		hotel.setHotelId(string);
		Hotel save = hotelRepository.save(hotel);
		return save;
	}

	@Override
	public List<Hotel> getHotelsList() {
		// TODO Auto-generated method stub
		List<Hotel> all = hotelRepository.findAll();
		return all;
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		// TODO Auto-generated method stub
		Optional<Hotel> byId = hotelRepository.findById(hotelId);
		Hotel hotel = byId.get();
		return hotel;
	}

	@Override
	
	public String deleteHotelByhotelId(String hotelId) {
		// TODO Auto-generated method stub
		
		hotelRepository.deleteById(hotelId);
		return "delete the hotel successfully !";
	}
	

}
