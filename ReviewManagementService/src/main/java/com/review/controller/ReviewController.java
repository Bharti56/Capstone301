package com.review.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.review.VO.ResponseTemplateVO;

import com.review.entity.Reviews;
import com.review.exception.ReviewNotFound;
import com.review.serviceimpl.ReviewServiceimpl;

@RestController
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private ReviewServiceimpl reviewServiceimpl;

	private Map<String, Object> response;

	@PostMapping("/reviewadd")
	public ResponseEntity<Map<String, Object>> createReviews(@RequestBody Reviews reviews) {
		response = new HashMap<>();
		response.put("message", "created entered");
		response.put("status", HttpStatus.OK);
		response.put("Body", reviewServiceimpl.createReview(reviews));
		response.put("Error", false);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@PutMapping("/updatereview/{reviewid}")
	public ResponseEntity<Map<String, Object>> updateReviewsById(@RequestBody Reviews reviews,
			@PathVariable long reviewid) throws ReviewNotFound {
		response = new HashMap<>();
		response.put("message", "Reviews updated successfully");
		response.put("status", HttpStatus.OK);
		response.put("Body", reviewServiceimpl.updateReviewByReviewId(reviews, reviewid));
		response.put("Error", false);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("getreview/{reviewid}")
	public ResponseTemplateVO getReviewsWithRestaurant(@PathVariable("reviewid") long reviewid) {
		return reviewServiceimpl.getReviewsWithRestaurant(reviewid);
	}

	@GetMapping("/getreviews")
	public ResponseEntity<Map<String, Object>> getAllReviewsofRestaurant() {
		response = new HashMap<>();
		response.put("message", "Here are the reviews of Restaurant");
		response.put("status", HttpStatus.OK);
		response.put("Body", reviewServiceimpl.getReview());
		response.put("Error", false);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}