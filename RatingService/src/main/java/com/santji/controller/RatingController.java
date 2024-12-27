package com.santji.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.santji.entity.Ratings;
import com.santji.service.RatingServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RatingController {

	@Autowired
	private RatingServiceImpl ratingServiceImpl;
	
	 @PostMapping("/ratings")
	public ResponseEntity<Ratings> createHandler(@RequestBody Ratings rating) {
		 
		Ratings saveData = ratingServiceImpl.create(rating);
	return	ResponseEntity.status(HttpStatus.CREATED).body(saveData);
	}
	 
	 @GetMapping("/ratings")
	 public ResponseEntity<List<Ratings>> getRatings() {
		 
		 List<Ratings> rating = ratingServiceImpl.getRating();
		return ResponseEntity.ok(rating);
		
	}
	 @GetMapping("/ratings/hotel/{hotelId}")
	 public ResponseEntity<List<Ratings>> getRatingByhotelID(@PathVariable String hotelId) {
		
		 List<Ratings> ratingByHotelId = ratingServiceImpl.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(ratingByHotelId);
	}
	 @GetMapping("/ratings/user/{userId}")
	 public ResponseEntity<List<Ratings>> getRatingByUserId(@PathVariable String userId) {
		List<Ratings> ratingByUserId = ratingServiceImpl.getRatingByUserId(userId);
		
		return ResponseEntity.ok(ratingByUserId);
	}
	
	
}
