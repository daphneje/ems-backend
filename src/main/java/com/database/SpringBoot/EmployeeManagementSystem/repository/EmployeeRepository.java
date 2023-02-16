package com.database.SpringBoot.EmployeeManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.database.SpringBoot.EmployeeManagementSystem.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	public Optional<Employee> findById(long employeeId);
	
	public Boolean existsByUsername(String username);
}
