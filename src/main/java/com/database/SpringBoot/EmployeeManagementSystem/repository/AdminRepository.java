package com.database.SpringBoot.EmployeeManagementSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.database.SpringBoot.EmployeeManagementSystem.entity.Admin;



public interface AdminRepository extends CrudRepository<Admin, Long> {
	public Admin findById(long adminId);
	
}
