package com.restaurant.service;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.constants.RestaurantServiceConstants;
import com.restaurant.exception.RestaurantServiceException;
import com.restaurant.model.Restaurant;
import com.restaurant.repo.RestaurantRepo;
import com.restaurant.util.ServerLoggerUtil;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepo restaurantRepo;

	@Override
	public List<Restaurant> getAllRestaurants() {

		ServerLoggerUtil.info(this.getClass(), "inside getAllRestaurants of RestaurantServiceImpl");
		List<Restaurant> restaurants = null;
		try {
			restaurants = restaurantRepo.findAll();
		} catch (HibernateException | PersistenceException exception) {
			throw new RestaurantServiceException(
					"Something went wrong while fetching all the restaurants " + exception.getMessage());
		}
		return restaurants;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Restaurant addRestaurant(Restaurant restaurant) {

		ServerLoggerUtil.info(this.getClass(), "inside addRestaurant of RestaurantServiceImpl");
		Restaurant savedRestaurant = null;
		try {
			savedRestaurant = restaurantRepo.save(restaurant);
		} catch (HibernateException | PersistenceException exception) {
			throw new RestaurantServiceException(
					RestaurantServiceConstants.RESTAURANT_NOT_SAVED_ERROR_MESSAGE + exception.getMessage());
		}
		return savedRestaurant;

	}

	@Override
	public List<Restaurant> getRestaurantsByRestaurantNameAndTableCount(String restaurantName,
			Integer numberOfTablesRequired) {

		ServerLoggerUtil.info(this.getClass(),
				"inside getRestaurantsByRestaurantNameAndTableCount of RestaurantServiceImpl");
		List<Restaurant> restaurants = null;
		try {
			restaurants = restaurantRepo.findByRestaurantNameContainingIgnoreCaseAndTableFleetGreaterThanEqual(
					restaurantName, numberOfTablesRequired);
		} catch (HibernateException | PersistenceException exception) {
			throw new RestaurantServiceException(RestaurantServiceConstants.SERVICE_EXCEPTION_COMMON_MESSAGE
					+ "getRestaurantsByRestaurantNameAndTableCount" + exception.getMessage());
		}
		return restaurants;

	}

	@Override
	public List<Restaurant> getRestaurantsByRestaurantAndAddressTableCount(String address,
			Integer numberOfTablesRequired) {

		ServerLoggerUtil.info(this.getClass(),
				"inside getRestaurantsByRestaurantAddressTableCount of RestaurantServiceImpl");
		List<Restaurant> restaurants = null;
		try {
			restaurants = restaurantRepo.findByRestaurantAddressContainingIgnoreCaseAndTableFleetGreaterThanEqual(
					address, numberOfTablesRequired);
		} catch (HibernateException | PersistenceException exception) {
			throw new RestaurantServiceException(RestaurantServiceConstants.SERVICE_EXCEPTION_COMMON_MESSAGE
					+ "getRestaurantsByRestaurantAddressTableCount" + exception.getMessage());
		}
		return restaurants;
	}

	@Override
	public Restaurant getRestaurantById(Integer restaurantId) {

		ServerLoggerUtil.info(this.getClass(), "inside getRestaurantById of RestaurantServiceImpl");
		Restaurant restaurant = null;
		try {
			restaurant = restaurantRepo.findOne(restaurantId);
		} catch (HibernateException | PersistenceException exception) {
			throw new RestaurantServiceException(RestaurantServiceConstants.SERVICE_EXCEPTION_COMMON_MESSAGE
					+ "getRestaurantById" + exception.getMessage());
		}
		return restaurant;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Restaurant updateRestaurant(Restaurant restaurant) {

		ServerLoggerUtil.info(this.getClass(), "inside updateRestaurant of RestaurantServiceImpl");
		Restaurant newRestaurant = null;
		int result = 0;
		try {
			result = restaurantRepo.updateRestaurantEntity(restaurant.getTableFleet(), restaurant.getRestaurantId());
			newRestaurant = restaurantRepo.findOne(restaurant.getRestaurantId());
		} catch (HibernateException | PersistenceException exception) {
			throw new RestaurantServiceException(RestaurantServiceConstants.SERVICE_EXCEPTION_COMMON_MESSAGE
					+ "updateRestaurant" + exception.getMessage());
		}
		if (result == 1)
			return newRestaurant;
		else
			return null;
	}

	@Override
	public void deleteRestaurantById(Integer restaurantId) {
		try {
			this.restaurantRepo.delete(restaurantId);
		} catch (HibernateException | PersistenceException exception) {
			throw new RestaurantServiceException(RestaurantServiceConstants.SERVICE_EXCEPTION_COMMON_MESSAGE
					+ "deleteRestaurantById" + exception.getMessage());
		}
	}
}
