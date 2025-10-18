package com.trsystems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trsystems.model.record.OrdersRecord;
import com.trsystems.service.OrdersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrdersService ordersService;

	@PostMapping("/register")
	public ResponseEntity<OrdersRecord> registerOrder(@RequestBody @Valid OrdersRecord ordersRecord) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ordersService.create(ordersRecord));
	}
}
