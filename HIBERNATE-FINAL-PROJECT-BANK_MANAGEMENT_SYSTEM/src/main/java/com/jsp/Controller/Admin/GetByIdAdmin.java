package com.jsp.Controller.Admin;

import java.util.Scanner;

import com.jsp.Service.AdminService;

public class GetByIdAdmin {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Admin ID to get details");
		int id = sc.nextInt();
		
		AdminService adminService = new AdminService();
		adminService.getAdminById(id);
	}
}