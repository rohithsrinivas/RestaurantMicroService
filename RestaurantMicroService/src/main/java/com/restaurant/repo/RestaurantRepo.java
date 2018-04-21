package com.restaurant.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restaurant.model.Restaurant;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer>{

	List<Restaurant>
	
	findByRestaurantNameContainingIgnoreCaseAndTableFleetGreaterThanEqual
	
	(String name,Integer numberOfTablesRequired);
	
	List<Restaurant> 
	
	findByRestaurantAddressContainingIgnoreCaseAndTableFleetGreaterThanEqual
	
	(String address,Integer numberOfTablesRequired);
	
	@Modifying(clearAutomatically=true)
	@Query("update Restaurant r set r.tableFleet=:newTableFleet where r.restaurantId=:restaurantId")
	
	Integer
	
	updateRestaurantEntity
	
	(@Param("newTableFleet") Integer integer,@Param("restaurantId") Integer restaurantId);
	
}
