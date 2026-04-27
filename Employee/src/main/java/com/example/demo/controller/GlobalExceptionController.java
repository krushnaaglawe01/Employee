package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.InvalidMobileNumber;

@RestControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler({InvalidMobileNumber.class}) 
	public Map<String, String> invalidMobileNumber(InvalidMobileNumber e) {
		Map<String, String> result = new HashMap<>();
		
		result.put("Status code", "901");
		result.put("msg", e.getMessage());
		
		return result;
	}
	
	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public Map<String, String> methodArgumentNotValidException(MethodArgumentNotValidException e) {

		Map<String, String> result = new HashMap<>();

		result.put("Status code", "901");
		result.put("msg", e.getMessage());
		return result;
	}
}
