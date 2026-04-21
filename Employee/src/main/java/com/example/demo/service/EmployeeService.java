package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	void add(Employee emp);
	
	List<Employee> display();
	
	Employee update(Employee emp, Integer id);
	
	void delete(Integer id);
}
