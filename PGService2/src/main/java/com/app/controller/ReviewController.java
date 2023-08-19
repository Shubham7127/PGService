package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Reviewdto;
import com.app.pojos.Reviews;
import com.app.service.ReviewsServ;

@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	public ReviewsServ reviewServ;
	
	@GetMapping
	public List<Reviewdto> getAllReview() {
	
		return reviewServ.getAllReview();
	}
	
	@PostMapping
	public ResponseEntity<?>addReview(Reviewdto review) {
		return ResponseEntity.ok(reviewServ.addReview(review));
	}
	
	
	
}
