package com.orderService.services;

import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.orderService.entities.Order;
import com.orderService.entities.User;
import com.orderService.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private UserClient userClient;

	public ResponseEntity<String> createOrder(Order order) {

		User user = userClient.getUserOfOrder((int) order.getUserId());

		if (Objects.isNull(user)) {

			return ResponseEntity.ok("User not found to process the order!");

		}
		if (user.getUserAddress().isBlank() && user.getUserAddress().isEmpty()) {
			return ResponseEntity.ok("Add shipping address!");
		}

		orderRepo.save(order);
		return ResponseEntity.ok("Order Added Successfully ");

	}

	public Order getOrder(long orderId) {
		Order order = orderRepo.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found!!"));

		User user = userClient.getUserOfOrder((int) order.getUserId());
		
		if (Objects.isNull(user)) {
			throw new RuntimeException("Please add a shipping address..");
		}
		return order;
	}

}
