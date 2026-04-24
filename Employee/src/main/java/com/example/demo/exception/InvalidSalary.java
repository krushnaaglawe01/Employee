package com.example.demo.exception;

public class InvalidSalary extends RuntimeException {

	public InvalidSalary(String message) {
        super(message);
    }
}
