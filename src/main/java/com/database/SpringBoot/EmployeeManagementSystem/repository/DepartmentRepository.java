package com.database.SpringBoot.EmployeeManagementSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.database.SpringBoot.EmployeeManagementSystem.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
	public Department findById(long departmentId);
}
