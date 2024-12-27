package com.santji.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.santji.entity.User;
import com.santji.service.UserService;
import com.santji.service.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		String string = UUID.randomUUID().toString();
		user.setUserId(string);
		System.out.println(user.toString());
		User save = userServiceImpl.createUser(user);
		return ResponseEntity.ok(save);
		
	}
	

	@GetMapping("/user")
	public ResponseEntity<List<User>> getUser() {
		List<User> userAll = userServiceImpl.getUserAll();
		return ResponseEntity.ok(userAll);
		
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
		 User userById = userServiceImpl.getUserById(userId);



		return ResponseEntity.ok(userById);
		
	}
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable String userId) {
		
		String deleteUserById = userServiceImpl.deleteUserById(userId);
		return ResponseEntity.ok(deleteUserById);
		
	}
	
	@PutMapping("/user/{userId}")
	public ResponseEntity<User> updateUserById(@RequestBody User user,@PathVariable String userId) {
		User updateUser = userServiceImpl.updateUser(user, userId);
		
	return	ResponseEntity.ok().body(updateUser);
	}
	
	
	
}
