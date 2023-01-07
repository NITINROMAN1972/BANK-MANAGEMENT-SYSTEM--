package com.jsp.Controller.Account;

import java.util.Scanner;

import com.jsp.Dto.Account;
import com.jsp.Service.CustomerService;

public class SaveAccount {
	public static void main(String[] args) {		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter customer id below");
		int customer_id = sc.nextInt();
		System.out.println("Enter initial balance");
		double balance = sc.nextDouble();
		
		if (balance > 999) {
			Account account = new Account();
			account.setBalance(balance);
			
			CustomerService customerService = new CustomerService();
			customerService.saveAccount(customer_id, account);
		}
		else {
			System.out.println("Initial amount should be minimum ₹1000");
		}
	}
}