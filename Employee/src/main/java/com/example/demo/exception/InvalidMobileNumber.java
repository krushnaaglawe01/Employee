package com.example.demo.exception;

public class InvalidMobileNumber extends RuntimeException{

	public InvalidMobileNumber(String msg) {
		super(msg);
	}
}
