package com.restaurantSearchService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurantSearchService.entity.RestaurantSearch;
import com.restaurantSearchService.service.RestaurantService;


@RestController
@RequestMapping("/rest")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/restget")
	public  List<RestaurantSearch> getRestaurant(){
		return restaurantService.getRestaurant();	
	}
	@GetMapping("/restName/{restName}")
	public List<RestaurantSearch> getRestaurantSearchByRestname(@PathVariable String restName ) {
		return restaurantService.findByRestName(restName);
	}
	
	@GetMapping("/restbyid/{restId}")
	public RestaurantSearch getRestaurantSearchByRestId(@PathVariable long restId)
	{
		return restaurantService.getRestaurantSearchByRestId(restId);
		
	}
	@GetMapping("/location/{location}")
	public List<RestaurantSearch> getRestaurantSearchByLocation(@PathVariable String location ) {
		return restaurantService.findByLocation(location);}
		
	@GetMapping("/restCuisine/{restCuisine}")
	public RestaurantSearch getByRestCuisine(@PathVariable String restCuisine) {
	return restaurantService.findByRestCuisine(restCuisine);
	}
	@GetMapping("/rating/{rating}")
	public RestaurantSearch getRestaurantSearchByRating(@PathVariable int rating) {
	return restaurantService.findByRating(rating);
	}
	@GetMapping("/distance/{distance}")
	public RestaurantSearch getByDistance(@PathVariable int distance) {
	return restaurantService.findByDistance(distance);
	}
	@GetMapping("/restBudget/{restBudget}")
	public RestaurantSearch getByRestBudget(@PathVariable long restBudget) {
	return restaurantService.getByRestBudget(restBudget);
	}
	
	
	@PostMapping("/add")
	public RestaurantSearch addRestaurant(@RequestBody RestaurantSearch restaurantSearch)
	{
		return restaurantService.addRestaurant(restaurantSearch);
	}
	
	@PutMapping("/rest")
	public RestaurantSearch updateRestaurant(@RequestBody RestaurantSearch restaurantSearch)
	{
		return this.restaurantService.updateRestaurant(restaurantSearch);
		}
	@DeleteMapping("/rest/{restId}")
	public ResponseEntity<HttpStatus> deleteRestaurant(@PathVariable String restId){
		try {
			this.restaurantService.deleteRestaurant(Long.parseLong(restId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
