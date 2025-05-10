package com.orderService.services;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.orderService.entities.User;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {
	
	
	@GetMapping("/user/{userId}")
	User getUserOfOrder(@PathVariable int userId);
}
