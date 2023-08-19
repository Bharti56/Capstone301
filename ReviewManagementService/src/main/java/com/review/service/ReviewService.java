package com.review.service;

import java.util.List;
import java.util.Optional;

import com.review.VO.ResponseTemplateVO;
import com.review.entity.Reviews;
import com.review.exception.ReviewNotFound;

public interface ReviewService {
	public Reviews createReview(Reviews review);
	public List<Reviews> getReview();
//	ResponseTemplateVO getReviewsWithRestaurant(long rId);
	Reviews updateReviewByReviewId(Reviews reviews, long reviewid) throws ReviewNotFound;
	ResponseTemplateVO getReviewsWithRestaurant(long reviewid);
	

}
