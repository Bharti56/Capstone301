package com.customer.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.review.entity.ReviewEvent;

@Service
public class ReviewConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReviewConsumer.class);
	
	@KafkaListener(topics="review_topics"
			,groupId="${spring.kafka.consumer.group-id}")
	public void comsume(ReviewEvent event) {
		LOGGER.info(String.format("Review event received in Customer Service => %s", event.toString()));
		 
	}

}
