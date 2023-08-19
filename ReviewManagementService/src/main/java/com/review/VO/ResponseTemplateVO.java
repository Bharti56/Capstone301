package com.review.VO;

import com.review.entity.Reviews;

public class ResponseTemplateVO {
private Reviews reviews;
private RestaurantSearch restaurantSearch;
public Reviews getReviews() {
	return reviews;
}
public void setReviews(Reviews reviews) {
	this.reviews = reviews;
}
public RestaurantSearch getRestaurantSearch() {
	return restaurantSearch;
}
public void setRestaurantSearch(RestaurantSearch restaurantSearch) {
	this.restaurantSearch = restaurantSearch;
}
public ResponseTemplateVO(Reviews reviews, RestaurantSearch restaurantSearch) {
	super();
	this.reviews = reviews;
	this.restaurantSearch = restaurantSearch;
}
public ResponseTemplateVO() {
	super();
	// TODO Auto-generated constructor stub
}

}
