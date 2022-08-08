package com.christian.repo;

import org.springframework.data.jpa.repository.JpaRepository;



import com.christian.model.Employee;

 

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

 

}
