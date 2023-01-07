package com.jsp.Service;

import com.jsp.Dao.AdminDao;
import com.jsp.Dto.Admin;

public class AdminService {
	
//	save admin
	public Admin saveAdmin(Admin admin) {
		AdminDao adminDao = new AdminDao();
		return adminDao.saveAdmin(admin);
	}
	
//	update admin
	public Admin updateAdmin(Admin admin) {
		AdminDao adminDao = new AdminDao();
		return adminDao.updateAdmin(admin);
	}
	
//	get admin by id
	public Admin getAdminById(int id) {
		AdminDao adminDao = new AdminDao();
		return adminDao.getAdminById(id);
	}
	
//	get all admin
	public void getAllAdmin() {
		AdminDao adminDao = new AdminDao();
		adminDao.getAllAdmin();
	}
	
//	delete admin
	public void deleteAdmin(int id) {
		AdminDao adminDao = new AdminDao();
		adminDao.deleteAdmin(id);
	}
	
//	approve admin
	public void approveAdmin(int id, String email, String password) {
		AdminDao adminDao = new AdminDao();
		adminDao.approveAdmin(id, email, password);
	}
}