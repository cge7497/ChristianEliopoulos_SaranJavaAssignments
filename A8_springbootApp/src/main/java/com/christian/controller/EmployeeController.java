package com.christian.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.christian.model.Employee;
import com.christian.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping("/employees")
	public List<Employee> listAllEmp() {
		return service.getAllEmps();

	}

	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmpId(@PathVariable Integer id) {
		Optional<Employee> emp = service.getEmpById(id);
		// return new ResponseEntity<Employee>(HttpStatus.OK);
		return emp;
	}
	
	@PutMapping("/employees")
	public void updateEmp(@RequestBody Employee newEmp){
		service.updateEmp(newEmp);
	}

	@PostMapping("/employees")
	public void addEmp(@RequestBody Employee emp) {
		service.addEmp(emp);
	}
}
