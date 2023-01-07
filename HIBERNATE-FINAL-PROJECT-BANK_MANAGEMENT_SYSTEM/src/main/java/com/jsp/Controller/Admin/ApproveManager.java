package com.jsp.Controller.Admin;

import java.util.Scanner;

import com.jsp.Service.AdminService;

public class ApproveManager {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Aprrove Admin to approve the Manager");
		System.out.println("Enter Admin id below");
		int id = sc.nextInt();
		System.out.println("Enter Admin email to verify");
		String email = sc.next();
		System.out.println("Enter Admin password to verify");
		String password = sc.next();
		
		AdminService adminService = new AdminService();
		adminService.approveAdmin(id, email, password);
		
	}
}