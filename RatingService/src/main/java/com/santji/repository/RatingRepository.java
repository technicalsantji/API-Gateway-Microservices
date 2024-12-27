package com.santji.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.santji.entity.Ratings;

@Service
public interface RatingRepository extends MongoRepository<Ratings, String>{

	
	List<Ratings> findByUserId(String userId);
	List<Ratings> findByHotelId(String hotelId);
	
}
