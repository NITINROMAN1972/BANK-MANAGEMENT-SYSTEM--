package com.jsp.Controller.Manager;

import java.util.Scanner;

import com.jsp.Service.ManagerService;

public class GetByIdManager {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Manager id to get details");
		int id = sc.nextInt();
		
		ManagerService managerService = new ManagerService();
		managerService.getManagerById(id);
	}
}