package com.santji.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.santji.entity.Hotel;
import com.santji.service.HotelServiceImpl;

@RestController
public class HotelController {

	@Autowired
	private HotelServiceImpl hotelServiceImpl;
	
	@PostMapping("/hotel")
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
		
		Hotel savehotel = hotelServiceImpl.createHotel(hotel);
		
		return ResponseEntity.ok(savehotel);
	}
	
	@GetMapping("/hotel")
	public ResponseEntity<List<Hotel>> gethotels() {
		List<Hotel> hotelsList = hotelServiceImpl.getHotelsList();
		
		return ResponseEntity.ok(hotelsList);
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
		Hotel hotelById = hotelServiceImpl.getHotelById(hotelId);
		
	return	ResponseEntity.ok().body(hotelById);
	}
	
	@DeleteMapping("/hotel/{hotelId}")
	public ResponseEntity<String> deleteHotel(@PathVariable String hotelId) {
		 String deleteHotelByhotelId = hotelServiceImpl.deleteHotelByhotelId(hotelId);
		
	return	ResponseEntity.ok().body(deleteHotelByhotelId);
	}
}
