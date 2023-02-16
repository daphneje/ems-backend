package com.database.SpringBoot.EmployeeManagementSystem.entity;

import java.util.Date;
import java.util.Set;

//import jakarta.persistence.CascadeType;
//import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private long employeeId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "department_id"), name = "department_id")
    private Department department;
	
	@ManyToMany
	@JoinTable(name = "employees_projects", joinColumns = { 
			@JoinColumn(name = "employee_id") }, inverseJoinColumns = { @JoinColumn(name = "project_id") })
	Set < Project > projects;
	
	@Column(name = "created_by")
	private String createdBy;
	
	
	@Column(name = "created_at", nullable = false, updatable = false, insertable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	
	@Column(name = "updated_at", nullable = false, updatable = false, insertable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String emailId, String username, String password, String mobileNumber, Department department, 
			Set<Project> projects, String createdBy, String updatedBy) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.department = department;
		this.projects = projects;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "Employee [Employee ID:" + employeeId + 
				", First Name:" + firstName + 
				", Last Name:" + lastName + 
				", username:" + username + 
				", password:" + password + 
				", Email:" + emailId + 
				", Mobile Number:" + mobileNumber + 
				", Department:" + department + 
				", Projects:" + projects + 
				", Created By:" + createdBy + 
				", Created At:" + createdAt + 
				", Updated By:" + updatedBy + 
				", Updated At:" + updatedAt + "]"; 
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
        
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set < Project > getProjects() {
        return projects;
    }

    public void setProjects(Set < Project > projects) {
        this.projects = projects;
    }

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
