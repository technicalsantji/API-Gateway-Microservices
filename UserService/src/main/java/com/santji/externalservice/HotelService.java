package com.santji.externalservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.santji.entity.Hotel;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {

	@Bean
	@GetMapping("/hotel/{hotelId}")
	Hotel getHotel(@PathVariable("hotelId") String hotelId);
}
