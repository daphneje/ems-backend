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

import com.database.SpringBoot.EmployeeManagementSystem.entity.Department;
import com.database.SpringBoot.EmployeeManagementSystem.service.DepartmentService;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/")
public class DepartmentController {
	@Autowired
	private DepartmentService ds;

	@GetMapping("/departments")
	public List<Department> getAllDepartments() {
		return ds.getAllDepartment();
	}

	@GetMapping("/departments/{departmentId}")
	public Department getDepartmentById(@PathVariable("departmentId") long departmentId) {
		return ds.getDepartmentById(departmentId);
	}

	@PostMapping("/departments")
	public Department addDepartment(@RequestBody Department dept) {
		return ds.add(dept);
	}

	@DeleteMapping("/departments/{departmentId}")
	public String deleteDepartment(@PathVariable("departmentId") long departmentId) {
		ds.deleteDepartment(departmentId);
		return "Department Deleted";
	}

	@PutMapping("/departments/{departmentId}")
	public String updateDepartment(@PathVariable("departmentId") long departmentId, @RequestBody Department dept) {
		ds.updateDepartmentData(departmentId, dept);
		return "Department Updated";
	}
}

