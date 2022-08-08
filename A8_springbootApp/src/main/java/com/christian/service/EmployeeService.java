package com.christian.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christian.model.Employee;
import com.christian.repo.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repo; // HAS A
	
	public List<Employee> getAllEmps(){
		return repo.findAll();
	}
	
	public Optional<Employee> getEmpById(int id){
		return repo.findById(id);
	}
	
	public void updateEmp(Employee updatedEmp) {
		try {
			// See if the employee exists
			Optional<Employee> opt = repo.findById(updatedEmp.getEmpId());
			Employee emp = opt.get();

			// Set the existing employee's properties to those of the updated
			emp.setName(updatedEmp.getName());
			emp.setSalary(updatedEmp.getSalary());
			emp.setDesignation(updatedEmp.getDesignation());
			repo.save(emp);
		}
		catch (NoSuchElementException | IllegalArgumentException e) {
			
		}
	}
	
	public void deleteEmp(Integer id) {
		repo.deleteById(id);
	}
	
	public void addEmp(Employee emp) {
		repo.save(emp);
	}
}
