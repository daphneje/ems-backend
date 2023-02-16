package com.database.SpringBoot.EmployeeManagementSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.database.SpringBoot.EmployeeManagementSystem.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	public Project findById(long projectId);
}
