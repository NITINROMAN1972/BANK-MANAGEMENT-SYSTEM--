package com.jsp.Controller.Account;

import java.util.Scanner;

import com.jsp.Service.CustomerService;

public class DepositeMoney {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Customer  id");
		int Customer_id = sc.nextInt();
		System.out.println("Enter your bank account id");
		int account_id = sc.nextInt();
		System.out.println("Enter the Amount to deposite");
		double amount = sc.nextDouble();
		
		if(amount > 0) {
				CustomerService customerService = new CustomerService();
				customerService.depositeMoney(Customer_id, account_id, amount);
		} else System.out.println("Please enter valid amount to deposite");
	}
}