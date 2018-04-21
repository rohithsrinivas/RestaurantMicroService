package com.restaurant.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.restaurant.service.RestaurantService;
import com.restaurant.service.RestaurantServiceImpl;

@Configuration
@EntityScan(basePackages="com.restaurant.model")
@ComponentScan(basePackages="com.restaurant.*")
@EnableJpaRepositories(basePackages="com.restaurant.repo")
@EnableTransactionManagement
public class RestaurantConfig {

	public RestaurantService restaurantService() {
		return new RestaurantServiceImpl();
	}
}
