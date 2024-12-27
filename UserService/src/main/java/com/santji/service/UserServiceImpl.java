package com.santji.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.santji.entity.Hotel;
import com.santji.entity.Ratings;
import com.santji.entity.User;
import com.santji.exception.ResourceNotFound;
import com.santji.externalservice.HotelService;
import com.santji.externalservice.RatingService;
import com.santji.repository.UserRepositiry;


@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserRepositiry userRepositiry;
	
	private Logger logger=LoggerFactory.getLogger(UserService.class);
		
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RatingService ratingService;
	 
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		User save = userRepositiry.save(user);
		return save;
	}

	@Override
	public List<User> getUserAll() {
		// TODO Auto-generated method stub
		return userRepositiry.findAll();
	}

	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		Optional<User> byId = Optional.of(userRepositiry.findById(userId).orElseThrow(()-> new ResourceNotFound()));
		User user = byId.get();

//==========================restTemplate=========================
		
//         Ratings[] ratinglist = restTemplate.getForObject("http://RATINGSERVICE/ratings/user/"+user.getUserId(), Ratings[].class);
//		  
//         List<Ratings> ratingUser = Arrays.stream(ratinglist).toList();
		
		List<Ratings> ratingUser = ratingService.getRatings(user.getUserId());
         
         logger.info("get=>",ratingUser);
		  
		  ratingUser.stream().map(ratings->{
	
			  
			//==========================restTemplate=========================
				
//			 ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotel/"+ratings.getHotelId(), Hotel.class);
//			  
//			 Hotel body = forEntity.getBody();
			  
			  
			  Hotel hotel = hotelService.getHotel(ratings.getHotelId());
			 
			 ratings.setHotel(hotel);
			  
			  return ratings;
			  
		  }).collect(Collectors.toList());
		 
		 user.setRatings(ratingUser);
		 return user;
	}

	@Override
	public String deleteUserById(String userId) {
		userRepositiry.deleteById(userId);
		return "User delete Successfully !";
	}

	@Override
	public User updateUser(User user,String userId) {
		// TODO Auto-generated method stub
		
		Optional<User> userGetbyId = Optional.of(userRepositiry.findById(userId).orElseThrow(()->new ResourceNotFound()));
		
		User user2 = userGetbyId.get();
		user2.setUserName(user.getUserName());
		user2.setUserAbout(user.getUserAbout());
		user2.setUserEmail(user.getUserEmail());
		User save = userRepositiry.save(user2);
		
		
		return save;
	}
	

}
