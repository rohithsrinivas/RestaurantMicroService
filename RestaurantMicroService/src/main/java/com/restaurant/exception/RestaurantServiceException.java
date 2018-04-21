package com.restaurant.exception;

public class RestaurantServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RestaurantServiceException() {
	}

	public RestaurantServiceException(String message) {
		super(message);
	}

	public RestaurantServiceException(Throwable cause) {
		super(cause);
	}

	public RestaurantServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestaurantServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
