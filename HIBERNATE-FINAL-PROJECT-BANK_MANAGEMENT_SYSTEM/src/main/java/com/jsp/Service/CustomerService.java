package com.jsp.Service;

import java.util.List;

import com.jsp.Dao.CustomerDao;
import com.jsp.Dto.Account;
import com.jsp.Dto.Customer;

public class CustomerService {
	
//	save customer
	public Customer saveCustomer(Customer customer) {
		CustomerDao customerDao = new CustomerDao();
		return customerDao.saveCustomer(customer);
	}
	
//	update customer
	public Customer updateCustomer(Customer customer) {
		CustomerDao customerDao = new CustomerDao();
		return customerDao.updateCustomer(customer);
	}
	
//	get customer by id
	public Customer getCustomerById(int id) {
		CustomerDao customerDao = new CustomerDao();
		return customerDao.getCustomerById(id);
	}
	
//	get all customer
	public void getAllCustomer() {
		CustomerDao customerDao = new CustomerDao();
		customerDao.getAllCustomer();
	}
	
//	delete customer
	public void deleteCustomer(int id) {
		CustomerDao customerDao = new CustomerDao();
		customerDao.deleteCustomer(id);
	}
	
//	save account
	public 	Account saveAccount(int customer_id, Account account) {
		CustomerDao customerDao = new CustomerDao();
		return customerDao.saveAccount(customer_id, account);
	}
	
//	deposite money in account
	public Account depositeMoney(int customer_id, int account_id, double amount) {
		CustomerDao customerDao = new CustomerDao();
		return customerDao.depositeMoney(customer_id, account_id, amount);
	}
	
//	transfer account money
	public Account transferMoney(int customer_id, int sender, int receiver, double transferAmount) {
		CustomerDao customerDao = new CustomerDao();
		return customerDao.transferMoney(customer_id, sender, receiver, transferAmount);
	}
	
//	how many accounts does a customer has ?
//	get account by id
	public List<Account> getAccountById(int customer_id){
		CustomerDao customerDao = new CustomerDao();
		return customerDao.getAccountById(customer_id);
	}
}