package com.jsp.Controller.Account;

import java.util.Scanner;

import com.jsp.Dto.Account;
import com.jsp.Service.CustomerService;


public class TransferMoney {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Customers Id");
		int customer_id = sc.nextInt();
		System.out.println("Enter your Sender's Account Id");
		int sender_id = sc.nextInt();
		System.out.println("Enter Receiver's Account id");
		int receiver_id = sc.nextInt();
		System.out.println("Enter transfer Amount");
		double transferAmount = sc.nextDouble();
		
		if(transferAmount > 0) {
			CustomerService customerService = new CustomerService();
			Account a = customerService.transferMoney(customer_id, sender_id, receiver_id, transferAmount);
			if(a != null) {
				System.out.println("Transfer is successful");
			} else System.out.println("Transaction failed");
		} else System.out.println("Please enter valid amount to transfer");
	}
}