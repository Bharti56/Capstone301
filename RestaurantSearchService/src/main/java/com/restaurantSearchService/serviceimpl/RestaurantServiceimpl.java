package com.restaurantSearchService.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurantSearchService.entity.RestaurantSearch;
import com.restaurantSearchService.repository.RestaurantRepository;
import com.restaurantSearchService.service.RestaurantService;

@Service
public class RestaurantServiceimpl implements RestaurantService {
	@Autowired
	 private RestaurantRepository restaurantRepository;
	@Override
	public RestaurantSearch addRestaurant(RestaurantSearch restaurantSearch) {
		return restaurantRepository.save(restaurantSearch);
	}
	@Override
	public List<RestaurantSearch> getRestaurant() {
		return  restaurantRepository.findAll();
	}
	@Override
	public List<RestaurantSearch> findByRestName(String restName) {
		return restaurantRepository.findByRestName(restName);
		
	}
	@Override
	public RestaurantSearch updateRestaurant(RestaurantSearch restaurantSearch) {
		// TODO Auto-generated method stub
		return restaurantRepository.save(restaurantSearch);
	}
	@Override
	public void deleteRestaurant(long restId) {
		
	restaurantRepository.deleteById(restId);;
	}
	@Override
	public RestaurantSearch findByRestCuisine(String restCuisine) {
		
		return restaurantRepository.findByRestCuisine(restCuisine);
	}
	@Override
	public RestaurantSearch findByDistance(int distance) {
	
		return restaurantRepository.findByDistance(distance);
	}
	@Override
	public List<RestaurantSearch> findByLocation(String location) {
		
		return restaurantRepository.findByLocation(location);
	}
	@Override
	public RestaurantSearch findByRating(int rating) {
		
		return restaurantRepository.findByRating(rating);
	}
	@Override
	public RestaurantSearch getByRestBudget(long restBudget) {
		
		return restaurantRepository.findByRestBudget(restBudget) ;
	}
	@Override
	public RestaurantSearch getRestaurantSearchByRestId(long restId) {
		// TODO Auto-generated method stub
		return restaurantRepository.findByRestId(restId);
	}

}
