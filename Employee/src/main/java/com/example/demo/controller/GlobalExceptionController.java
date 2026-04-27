package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.InvalidMobileNumber;

@RestControllerAdvice
public class GlobalExceptionController {

//	@ExceptionHandler({InvalidMobileNumber.class}) 
//	public Map<String, String> invalidMobileNumber(InvalidMobileNumber e) {
//		Map<String, String> result = new HashMap<>();
//		
//		result.put("Status code", "901");
//		result.put("msg", e.getMessage());
//		
//		return result;
//	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, Object> handleValidation(MethodArgumentNotValidException e) {

	    Map<String, Object> response = new HashMap<>();
	    Map<String, String> errors = new HashMap<>();

	    e.getBindingResult().getFieldErrors().forEach(error -> {
	        errors.put(error.getField(), error.getDefaultMessage());
	    });

	    response.put("status", 400);
	    response.put("errors", errors);

	    return response;
	}

}
