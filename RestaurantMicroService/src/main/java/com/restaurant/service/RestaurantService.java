package com.restaurant.service;

import java.util.List;

import com.restaurant.model.Restaurant;

public interface RestaurantService {
	
	List<Restaurant> getAllRestaurants();
	
	Restaurant addRestaurant(Restaurant restaurant);
	
	Restaurant updateRestaurant(Restaurant restaurant);
	
	Restaurant getRestaurantById(Integer restaurantId);

	List<Restaurant> getRestaurantsByRestaurantAndAddressTableCount(String address, Integer tableCount);

	List<Restaurant> getRestaurantsByRestaurantNameAndTableCount(String restaurantName, Integer tableCount);

}
