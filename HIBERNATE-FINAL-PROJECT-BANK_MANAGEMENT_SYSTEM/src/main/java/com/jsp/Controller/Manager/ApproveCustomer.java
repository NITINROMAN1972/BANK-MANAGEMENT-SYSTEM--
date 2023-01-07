package com.jsp.Controller.Manager;

import java.util.Scanner;

import com.jsp.Dto.Manager;
import com.jsp.Service.ManagerService;

public class ApproveCustomer {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Manager id below");
		int id = sc.nextInt();
		System.out.println("Enter Manager email to verify");
		String email = sc.next();
		System.out.println("Enter Manager password to verify");
		String password = sc.next();
		
		Manager manager = new Manager();
		manager.setId(id);
		manager.setEmail(email);
		manager.setPassword(password);
		
		ManagerService managerService = new ManagerService();
		managerService.approveManager(manager);
	}
}