package com.restaurant.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler{

	@ExceptionHandler(RestaurantServiceException.class)
	public ResponseEntity<Map<String, String>> noRestaurantFoundBusinessExceptionHandler(RestaurantServiceException exception){
		return this.getErrorResponse(exception);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> genericExceptionHandler(Exception exception){
		return this.getErrorResponse(exception);
	}
	
	private ResponseEntity<Map<String,String>> getErrorResponse(Exception exception){
		Map<String , String> response = new HashMap<>();
		response.put("message", exception.getMessage());
		return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK);
	}
}
