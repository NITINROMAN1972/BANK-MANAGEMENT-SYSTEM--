package com.jsp.Controller.Manager;

import java.util.Scanner;

import com.jsp.Dto.Manager;
import com.jsp.Service.ManagerService;

public class SaveManager {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Manager name below:");
		String name = sc.nextLine();
		System.out.println("Enter Manager email below:");
		String email = sc.nextLine();
		System.out.println("Enter Manager password below:");
		String password = sc.nextLine();
		System.out.println("Enter Manager status below:");
		String status = sc.nextLine();
		
		Manager manager = new Manager();
		manager.setName(name);
		manager.setEmail(email);
		manager.setPassword(password);
		manager.setStatus(status);
		
		ManagerService managerService = new ManagerService();
		managerService.saveManager(manager);
	}
}