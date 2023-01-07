package com.jsp.Controller.Manager;

import java.util.Scanner;

import com.jsp.Service.ManagerService;

public class DeleteCustomer {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Manager id");
		int manager_id = sc.nextInt();
		System.out.println("Enter Customer id");
		int customer_id = sc.nextInt();
		
		ManagerService managerService = new ManagerService();
		managerService.deleteCustomer(manager_id, customer_id);
		
		
	}
}