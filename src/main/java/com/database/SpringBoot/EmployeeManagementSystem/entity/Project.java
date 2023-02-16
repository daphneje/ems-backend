package com.database.SpringBoot.EmployeeManagementSystem.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private long projectId;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "project_info")
	private String projectInfo;
	
    @ManyToMany(mappedBy = "projects", cascade = { CascadeType.ALL })
    @JsonIgnore
    private Set<Employee> employees;
    
    @ManyToMany(mappedBy = "projects", cascade = { CascadeType.ALL })
    private Set<Department> departments;
	
	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_at")
	private String createdAt;
	
	public Project() {
		super();
	}
	

	public Project(String projectName, String projectInfo, Set<Employee> employees, Set<Department> departments,
			String createdBy) {
		this.projectName = projectName;
		this.projectInfo = projectInfo;
		this.employees = employees;
		this.departments = departments;
		this.createdBy = createdBy;
	}


	@Override
	public String toString() {
		return "Project [Project ID:" + projectId + 
				", Project Name:" + projectName + 
				", Project Info:" + projectInfo + 
				", Departments:" + departments + 
				", Employees:" + employees + 
				", Created By:" + createdBy +
				", Created AT:" + createdAt + 
				"]";
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectInfo() {
		return projectInfo;
	}

	public void setProjectInfo(String projectInfo) {
		this.projectInfo = projectInfo;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
}
