package com.database.SpringBoot.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.database.SpringBoot.EmployeeManagementSystem.entity.Project;
import com.database.SpringBoot.EmployeeManagementSystem.repository.ProjectRepository;

@Component
public class ProjectService {
	@Autowired
	private ProjectRepository pr;

	public List<Project> getAllProject() {
		List<Project> projectList = (List<Project>) pr.findAll();
		return projectList;
	}
	public Project getProjectById(long projectId) {
		Project proj = pr.findById(projectId);
		return proj;
	}
	public Project add(Project proj) {
		pr.save(proj);
		return proj;
	}
	public void deleteProject(long projectId) {
		pr.deleteById(projectId);		
	}
	public void updateProjectData(long projectId, Project proj) {
		proj.setProjectId(projectId);
		
		pr.save(proj);
	}
	
}