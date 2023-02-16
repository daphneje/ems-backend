package com.database.SpringBoot.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.database.SpringBoot.EmployeeManagementSystem.entity.Employee;
import com.database.SpringBoot.EmployeeManagementSystem.exception.UserNotFoundException;
import com.database.SpringBoot.EmployeeManagementSystem.service.EmployeeService;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/")
public class EmployeeController {
	@Autowired
	private EmployeeService es;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return es.getAllEmployee();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId") long employeeId) {
		return es.getEmployeeById(employeeId)
				.orElseThrow(() -> new UserNotFoundException("User by Employee ID: " + employeeId + " was not found"));
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp) {
		return es.add(emp);
	}

	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId") long employeeId) {
		es.deleteEmployee(employeeId);
	}

	@PutMapping("/employees/{employeeId}")
	public void updateEmployee(@PathVariable("employeeId") long employeeId, @RequestBody Employee emp) {
		es.updateEmployeeData(employeeId, emp);
	}
}

