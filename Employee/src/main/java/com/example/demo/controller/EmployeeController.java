package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;




@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService es;
	
	
	@GetMapping("display")
	public List<Employee> display() {
		return es.display();
	}

	@PostMapping("add")
	public void add(@Valid @RequestBody Employee emp) {
		// TODO: process POST request
		es.add(emp);
	}

	@PutMapping("update/{id}")
	public Employee update(@PathVariable("id") Integer id, @RequestBody Employee emp) {
		// TODO: process PUT request

		return es.update(emp, id);
	}

	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		es.delete(id);
	}
}
 