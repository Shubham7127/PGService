package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.BookingCartServ;

@RestController
@RequestMapping("/bookingCart")
public class BookingCartController {

	@Autowired
	public BookingCartServ bookingCartService;
	
	@PostMapping("/add")
	public String addToCart(@RequestParam Long propertyId,@RequestParam Long userId) {
		return bookingCartService.addPropertiesToCart(userId, userId);
	}
	
	@GetMapping("/show_cart")
	public ResponseEntity<?> showCartContents() {
		return  ResponseEntity.status(HttpStatus.OK).body(bookingCartService.getCartDetails());
		
	}
}
