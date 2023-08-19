package com.review.entity;
//review service will create an Reviewevent and published to the kafka 
public class ReviewEvent {
	private String message;
	private String status;
	private Reviews review;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Reviews getReview() {
		return review;
	}
	public void setReview(Reviews review) {
		this.review = review;
	}
	public ReviewEvent(String message, String status, Reviews review) {
		super();
		this.message = message;
		this.status = status;
		this.review = review;
	}
	public ReviewEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ReviewEvent [message=" + message + ", status=" + status + ", review=" + review + "]";
	}
	
	

}
