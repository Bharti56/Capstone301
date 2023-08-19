package com.review.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.review.entity.ReviewEvent;
import com.review.entity.Reviews;
import com.review.serviceimpl.ReviewProducer;

@RestController
@RequestMapping("/a1")
public class ReviewControllerKafka {
	
	
	private  ReviewProducer reviewProducer;

	public ReviewControllerKafka(ReviewProducer reviewProducer) {
		super();
		this.reviewProducer = reviewProducer;
	}

	@PostMapping("/reviewk")
	public String giveReview(@RequestBody Reviews review) {
		review.setReviewid(review.getReviewid());
		ReviewEvent event = new ReviewEvent();
		event.setStatus("pending");
		event.setMessage("Review is in pending state");
		event.setReview(review);
		reviewProducer.sendMessage(event);
		
		return "Order Placed Succesfully :)";
	}
	

}
