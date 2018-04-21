package com.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.model.Restaurant;
import com.restaurant.service.RestaurantService;

@RestController
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	@GetMapping(value="/getRestaurantsByName/{restaurantName}/{numberOfTablesRequired}")
	public ResponseEntity<List<Restaurant>> getRestaurantsByName
	(@PathVariable(name="restaurantName",required=true) String restaurantName,
			@PathVariable(name="numberOfTablesRequired",required=true) Integer numberOfTablesRequired){
		return new ResponseEntity<List<Restaurant>>(restaurantService.
				getRestaurantsByRestaurantNameAndTableCount(restaurantName,numberOfTablesRequired),
				HttpStatus.OK);
	}
	
	@GetMapping(value="/getRestaurantsByAddress/{address}/{numberOfTablesRequired}")
	public ResponseEntity<List<Restaurant>> getRestaurantsByAddress
	(@PathVariable(name="address",required=true) String address,
			@PathVariable(name="numberOfTablesRequired",required=true) Integer numberOfTablesRequired){
		return new ResponseEntity<List<Restaurant>>(restaurantService.
				getRestaurantsByRestaurantAndAddressTableCount(address, numberOfTablesRequired),
				HttpStatus.OK);
	}
	
	@GetMapping(value="/getRestaurantById/{restaurantId}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("restaurantId") Integer restaurantId){
		return new ResponseEntity<Restaurant>(restaurantService.getRestaurantById(restaurantId), HttpStatus.OK);
	}
	
	@GetMapping(value="/getAll")
	public ResponseEntity<List<Restaurant>> getAllRestaurants(){
		return new ResponseEntity<List<Restaurant>>(restaurantService.getAllRestaurants(), HttpStatus.OK);
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant){
		return new ResponseEntity<Restaurant>(restaurantService.addRestaurant(restaurant), HttpStatus.OK);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant){
		return new ResponseEntity<Restaurant>(restaurantService.updateRestaurant(restaurant),HttpStatus.OK);
	}

}
