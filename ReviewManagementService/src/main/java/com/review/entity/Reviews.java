package com.review.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reviews {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reviewid;
	private String review;
	private long rating;
	private long restId;
	public long getReviewid() {
		return reviewid;
	}
	public void setReviewid(long reviewid) {
		this.reviewid = reviewid;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public long getRating() {
		return rating;
	}
	public void setRating(long rating) {
		this.rating = rating;
	}
	public long getRestId() {
		return restId;
	}
	public void setRestId(long restId) {
		this.restId = restId;
	}
	public Reviews(long reviewid, String review, long rating, long restId) {
		super();
		this.reviewid = reviewid;
		this.review = review;
		this.rating = rating;
		this.restId = restId;
	}
	public Reviews() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Reviews [reviewid=" + reviewid + ", review=" + review + ", rating=" + rating + ", restId=" + restId
				+ "]";
	}
	
	

}
