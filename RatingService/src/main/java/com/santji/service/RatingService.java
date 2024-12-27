package com.santji.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.santji.entity.Ratings;
@Service
public interface RatingService {
	
	//create rating
	Ratings create(Ratings ratings);
	
	List<Ratings> getRating();
	
	List<Ratings> getRatingByUserId(String userId);
	
	List<Ratings> getRatingByHotelId(String hotelId);
	

}
