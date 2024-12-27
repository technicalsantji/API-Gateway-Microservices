package com.santji.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santji.entity.User;

public interface UserRepositiry extends JpaRepository<User, String> {

	
}
