package com.santji.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santji.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,String> {

}
