package com.jsp.Controller.Account;

import java.util.Scanner;

import com.jsp.Service.CustomerService;

public class GetByIdAccount {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Customer id ");
		int customer_id= sc.nextInt();
		
		CustomerService customerService = new CustomerService();
		customerService.getAccountById(customer_id);
	}
}