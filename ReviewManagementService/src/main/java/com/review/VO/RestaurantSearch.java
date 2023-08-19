package com.review.VO;

public class RestaurantSearch {

	private long restId;
	private String restName;
	private String restCuisine;
	private long restBudget;
	private String location;
	private int rating;
	private int distance;
	


	public RestaurantSearch(long restId, String restName, String restCuisine, long restBudget, String location,
			int rating, int distance) {
		super();
		this.restId = restId;
		this.restName = restName;
		this.restCuisine = restCuisine;
		this.restBudget = restBudget;
		this.location = location;
		this.rating = rating;
		this.distance = distance;
	}
	public long getRestId() {
		return restId;
	}
	public void setRestId(long restId) {
		this.restId = restId;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public String getRestCuisine() {
		return restCuisine;
	}
	public void setRestCuisine(String restCuisine) {
		this.restCuisine = restCuisine;
	}
	public long getRestBudget() {
		return restBudget;
	}
	public void setRestBudget(long restBudget) {
		this.restBudget = restBudget;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		return "RestaurantSearch [restId=" + restId + ", restName=" + restName + ", restCuisine=" + restCuisine
				+ ", restBudget=" + restBudget + ", location=" + location + ", rating=" + rating + ", distance="
				+ distance + "]";
	}
	public RestaurantSearch() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
