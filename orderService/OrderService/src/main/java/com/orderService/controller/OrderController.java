package com.orderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderService.entities.Order;
import com.orderService.services.OrderService;



@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping
	public ResponseEntity<String> createOrder(@RequestBody Order order) {
		
		return orderService.createOrder(order);
		
	}
	
	
	@GetMapping("/{orderId}")
	public Order getOrder(@PathVariable long orderId) {
		
		return orderService.getOrder(orderId);
		
	}

}
