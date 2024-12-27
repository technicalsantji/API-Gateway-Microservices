package com.santji.service;

import java.util.List;

import com.santji.entity.User;

public interface UserService {

	User createUser(User user);
	List<User> getUserAll();
	User getUserById(String userId);
	String deleteUserById(String userId);
	User updateUser(User user,String userId);
	
}
