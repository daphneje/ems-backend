package com.database.SpringBoot.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.database.SpringBoot.EmployeeManagementSystem.entity.Department;
import com.database.SpringBoot.EmployeeManagementSystem.repository.DepartmentRepository;

@Component
public class DepartmentService {
	@Autowired
	private DepartmentRepository dr;

	public List<Department> getAllDepartment() {
		List<Department> departmentList = (List<Department>) dr.findAll();
		return departmentList;
	}
	
	public Department getDepartmentById(long departmentId) {
		Department dept = dr.findById(departmentId);
		return dept;
	}
	
	public Department add(Department dept) {
		dr.save(dept);
		return dept;
	}
	public void deleteDepartment(long departmentId) {
		dr.deleteById(departmentId);		
	}
	
	public void updateDepartmentData(long departmentId, Department dept) {
		dept.setDepartmentId(departmentId);
		
		dr.save(dept);
	}
	
}