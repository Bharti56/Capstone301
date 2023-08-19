package com.restaurantSearchService.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurantSearchService.entity.RestaurantSearch;
@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantSearch ,Long> {

//@Query(value="select * from restaurant_search where rest_name='restname'")
public List<RestaurantSearch> findByRestName(String restName);
@Query(value="select * from restaurant_search where location='location'")
public List<RestaurantSearch>findByLocation(String location);
public RestaurantSearch findByRestBudget(long restBudget);
public RestaurantSearch findByRating(int rating);
public RestaurantSearch findByDistance(int distance);
public RestaurantSearch findByRestCuisine(String restCuisine);
public RestaurantSearch findByRestId(long restId);


	
}