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

import com.database.SpringBoot.EmployeeManagementSystem.entity.Admin;
import com.database.SpringBoot.EmployeeManagementSystem.service.AdminService;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/")
public class AdminController {
	@Autowired
	private AdminService as;

	@GetMapping("/admin")
	public List<Admin> getAllAdmins() {
		return as.getAllAdmin();
	}

	@GetMapping("/admins/{adminId}")
	public Admin getAdminById(@PathVariable("adminId") long adminId) {
		return as.getAdminById(adminId);
	}

	@PostMapping("/admins")
	public Admin addDepartment(@RequestBody Admin admin) {
		return as.add(admin);
	}

	@DeleteMapping("/admins/{adminId}")
	public String deleteDepartment(@PathVariable("adminId") long adminId) {
		as.deleteAdmin(adminId);
		return "Admin Deleted";
	}

	@PutMapping("/admins/{adminId}")
	public String updateDepartment(@PathVariable("adminId") long adminId, @RequestBody Admin admin) {
		as.updateAdminData(adminId, admin);
		return "Admin Updated";
	}
}

