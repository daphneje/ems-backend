package com.database.SpringBoot.EmployeeManagementSystem.service;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.database.SpringBoot.EmployeeManagementSystem.entity.Employee;
import com.database.SpringBoot.EmployeeManagementSystem.repository.EmployeeRepository;

@Component
public class EmployeeService {
	@Autowired
	private EmployeeRepository er;

	public List<Employee> getAllEmployee() {
		List<Employee> employeeList = (List<Employee>) er.findAll();
		return employeeList;
	}
	
	public Optional<Employee> getEmployeeById(long employeeId) {
		return er.findById(employeeId);
	}
	
	public Employee add(Employee emp) {
		er.save(emp);
		return emp;
	}
	
	public void deleteEmployee(long employeeId) {
		er.deleteById(employeeId);		
	}
	
	public void updateEmployeeData(long employeeId, Employee emp) {
		emp.setEmployeeId(employeeId);
		
		er.save(emp);
	}
	
}