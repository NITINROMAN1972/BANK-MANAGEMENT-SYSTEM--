package com.jsp.Controller.Customer;

import com.jsp.Service.CustomerService;

public class GetAllCustomer {
	public static void main(String[] args) {
		
		CustomerService customerService = new CustomerService();
		customerService.getAllCustomer();
	}

}
