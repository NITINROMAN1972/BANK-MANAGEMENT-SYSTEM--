package com.jsp.Controller.Admin;

import com.jsp.Service.AdminService;

public class GetAllAdmin {
	public static void main(String[] args) {
		
		AdminService adminService = new AdminService();
		adminService.getAllAdmin();
	}
}