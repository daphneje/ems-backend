package com.database.SpringBoot.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.database.SpringBoot.EmployeeManagementSystem.entity.Admin;
import com.database.SpringBoot.EmployeeManagementSystem.repository.AdminRepository;


@Component
public class AdminService {
	@Autowired
	private AdminRepository ar;

	public List<Admin> getAllAdmin() {
		List<Admin> adminList = (List<Admin>) ar.findAll();
		return adminList;
	}
	
	public Admin getAdminById(long adminId) {
		Admin admin = ar.findById(adminId);
		return admin;
	}
	
	public Admin add(Admin admin) {
		ar.save(admin);
		return admin;
	}
	
	public void deleteAdmin(long adminId) {
		ar.deleteById(adminId);		
	}

	public void updateAdminData(long adminId, Admin admin) {
		admin.setAdminId(adminId);
		
		ar.save(admin);
	}
	
}