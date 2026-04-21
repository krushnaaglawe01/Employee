package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public void add(Employee emp) {
		// TODO Auto-generated method stub
		
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
