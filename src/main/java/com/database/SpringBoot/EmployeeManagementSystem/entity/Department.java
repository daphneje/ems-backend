package com.database.SpringBoot.EmployeeManagementSystem.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private long departmentId;

	@Column(name = "department_name")
	private String departmentName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Employee> employees;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "created_at")
	private String createdAt;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "departments_projects", joinColumns = {
			@JoinColumn(name = "department_id") }, inverseJoinColumns = { @JoinColumn(name = "project_id") })
	Set < Project > projects;

	public Department() {
		super();
	}
	
	public Department(String departmentName, Set<Employee> employees, String createdBy,
			String createdAt, Set<Project> projects) {
		super();
		this.departmentName = departmentName;
		this.employees = employees;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Department [Department ID:" + departmentId + 
				", Department Name:" + departmentName + 
				", Employees:" + employees + 
				", Created By:" + createdBy + 
				", Created At:" + createdAt + "]"; 
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
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
	
    public Set < Project > getProjects() {
        return projects;
    }

    public void setProjects(Set < Project > projects) {
        this.projects = projects;
    }
}
