package com.example.demo.service;

public class InvalidSalary extends RuntimeException {

	public InvalidSalary(String message) {
        super(message);
    }
}
