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

import com.database.SpringBoot.EmployeeManagementSystem.entity.Project;
import com.database.SpringBoot.EmployeeManagementSystem.service.ProjectService;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/")
public class ProjectController {
	@Autowired
	private ProjectService ps;

	@GetMapping("/projects")
	public List<Project> getAllProjects() {
		return ps.getAllProject();
	}

	@GetMapping("/projects/{projectId}")
	public Project getProjectById(@PathVariable("projectId") long projectId) {
		return ps.getProjectById(projectId);
	}

	@PostMapping("/projects")
	public Project addProject(@RequestBody Project proj) {
		return ps.add(proj);
	}

	@DeleteMapping("/projects/{projectId}")
	public String deleteProject(@PathVariable("projectId") long projectId) {
		ps.deleteProject(projectId);
		return "Project Deleted";
	}

	@PutMapping("/projects/{projectId}")
	public String updateProject(@PathVariable("projectId") long projectId, @RequestBody Project proj) {
		ps.updateProjectData(projectId, proj);
		return "Project Updated";
	}
}

