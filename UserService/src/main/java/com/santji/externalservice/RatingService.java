package com.santji.externalservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.santji.entity.Ratings;

@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

	@GetMapping("/ratings/user/{userId}")
	List<Ratings> getRatings(@PathVariable String userId);
	
	
	
}
