package com.jsp.Controller.Admin;

import java.util.Scanner;

import com.jsp.Dto.Admin;
import com.jsp.Service.AdminService;

public class SaveAdmin {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Admin name below:");
		String name = sc.nextLine();
		System.out.println("Enter Admin email below:");
		String email = sc.nextLine();
		System.out.println("Enter Admin password below:");
		String password = sc.nextLine();
		
		Admin admin = new Admin();
		admin.setName(name);
		admin.setEmail(email);
		admin.setPassword(password);
		
		AdminService adminService = new AdminService();
		adminService.saveAdmin(admin);
	}
}