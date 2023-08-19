package com.review.serviceimpl;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.review.entity.ReviewEvent;
import com.review.repository.ReviewRepository;

@Service
public class ReviewProducer {

	

	private static final Logger log= LoggerFactory.getLogger(ReviewProducer.class);

	private NewTopic topic;
	private KafkaTemplate<String, ReviewEvent> kafkaTemplate;

	public ReviewProducer(NewTopic topic, KafkaTemplate<String, ReviewEvent> kafkaTemplate) {
		super();
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(ReviewEvent event) {
		log.info(String.format("Review event => %s", event.toString()));

		// create message and send message it to tpic via kafka template

		Message<ReviewEvent> message = MessageBuilder
				.withPayload(event).setHeader(KafkaHeaders.TOPIC, topic.name())
				.build();
		kafkaTemplate.send(message);
	

	}

}
