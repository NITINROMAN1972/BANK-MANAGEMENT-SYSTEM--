package com.jsp.Controller.Customer;

import java.util.Scanner;

import com.jsp.Dto.Customer;
import com.jsp.Service.CustomerService;

public class UpdateCustomer {
	public static void main(String[] args) {
		
		Customer customer = new Customer();
		customer.setId(3);
//		customer.setName("nitin");
//		customer.setAddrs("koperkhairane");
		customer.setAdhar_no("3333 3333 3333 3333");
//		customer.setStatus("approved");
		
		CustomerService customerService = new CustomerService();
		customerService.updateCustomer(customer);
	}
}