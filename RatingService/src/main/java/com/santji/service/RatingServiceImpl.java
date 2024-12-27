package com.santji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santji.entity.Ratings;
import com.santji.repository.RatingRepository;



@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	
	@Override
	public Ratings create(Ratings ratings) {
		// TODO Auto-generated method stub
		
		Ratings save = ratingRepository.save(ratings);
		return save;
	}

	@Override
	public List<Ratings> getRating() {
		// TODO Auto-generated method stub
		List<Ratings> all = ratingRepository.findAll();
		return all;
	}

	@Override
	public List<Ratings> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		List<Ratings> byUserId = ratingRepository.findByUserId(userId);
		return byUserId;
	}

	@Override
	public List<Ratings> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		List<Ratings> byHotelId = ratingRepository.findByHotelId(hotelId);
		return byHotelId;
	}

}
