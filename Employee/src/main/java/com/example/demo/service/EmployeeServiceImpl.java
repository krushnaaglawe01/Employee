package com.example.demo.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.InvalidMobileNumber;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public void add(Employee emp) {
		// TODO Auto-generated method stub
		Pattern mobPattern = Pattern.compile("[6-9][0-9]{9}$");
		Matcher mobMatcher = mobPattern.matcher(emp.getMob());

		if (!mobMatcher.matches()) {
			throw new InvalidMobileNumber("Mobile Number must be start from 6,7,8,9 and length is 10");
		}
		
		Float salary = emp.getSalary();
		if(salary == null || salary <= 0 || salary > 1000000) {
			throw new InvalidSalary("Salary must be greater than 0  and less than 1000000");
		}
			empRepo.save(emp);

	}
	

	@Override
	public List<Employee> display() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}
	
	@Override
	public Employee update(Employee emp, Integer id) {
		emp.setId(id);
		return empRepo.save(emp);
	}
	
	@Override
	public void delete(Integer id) {
		empRepo.deleteById(id);
	}

}
