package com.review.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.review.VO.ResponseTemplateVO;
import com.review.VO.RestaurantSearch;
import com.review.entity.Reviews;
import com.review.exception.ReviewNotFound;
import com.review.repository.ReviewRepository;
import com.review.service.ReviewService;

@Service
public class ReviewServiceimpl implements ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private KafkaTemplate<String , Reviews> kafkaTemplate;
	
	private static final String TOPIC ="Review_topic";

	@Override
	public Reviews createReview(Reviews reviews) {
		kafkaTemplate.send(TOPIC,reviews);
		return reviewRepository.save(reviews);
	}

	@Override
	public List<Reviews> getReview() {
		// TODO Auto-generated method stub
		return reviewRepository.findAll();
	}
	@Override
	public Reviews updateReviewByReviewId(Reviews reviews ,long reviewid) throws ReviewNotFound {
		Reviews rev = reviewRepository.findById(reviewid).orElseThrow(()->new ReviewNotFound("Reviews", "reviewid", reviewid));
		rev.setReview(reviews.getReview());
		rev.setRating(reviews.getRating());
		return reviewRepository.save(rev);
	}
@Override
	public ResponseTemplateVO getReviewsWithRestaurant(long reviewid) {
	ResponseTemplateVO vo = new ResponseTemplateVO();
	Reviews reviews =  reviewRepository.findByReviewid(reviewid);
	//with the help of rest template we will call the restaurant Service and get the Restaurant object
			RestaurantSearch restSearch = restTemplate.getForObject("http://localhost:8082/rest/restbyid/" + reviews.getRestId(),RestaurantSearch.class);
			vo.setRestaurantSearch(restSearch);
			vo.setReviews(reviews);
		return vo;
	}

	

	

	

	

}
