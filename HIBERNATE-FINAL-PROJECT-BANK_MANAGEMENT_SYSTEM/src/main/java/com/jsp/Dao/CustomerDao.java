package com.jsp.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.Dto.Account;
import com.jsp.Dto.Customer;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nitin");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
		
//	save customer
	public Customer saveCustomer(Customer customer) {
		List<Customer> cus = getAllCustomer();
		for(Customer c : cus) {
			if(c.getAdhar_no().equals(customer.getAdhar_no())       ) {
				System.out.println("Customer with Adhar No. "+customer.getAdhar_no()+" already exists");
				return null;
			}
		}
		customer.setStatus("unapproved");
		System.out.println("Please wait for the Manager to approve Customer");
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		return customer;
	}
	
//	update customer
	public Customer updateCustomer(Customer customer) {
		Customer c = entityManager.find(Customer.class, customer.getId());
		if(customer.getName() != null) {
			c.setName(customer.getName());
			System.out.println("Customer name has been updated");
		}
		if(customer.getAddrs() != null) {
			c.setAddrs(customer.getAddrs());
			System.out.println("Customer address has been updated");
		}
		if(customer.getAdhar_no() != null) {
			c.setAdhar_no(customer.getAdhar_no());
			System.out.println("Customer adhar no. has been updated");
		}
		if(customer.getStatus() != null) {
			c.setStatus(customer.getStatus());
			System.out.println("Customer status has been updated");
		}
		if(c != null) {
			entityTransaction.begin();
			entityManager.merge(c);
			entityTransaction.commit();
			System.out.println("Customer with ID as "+ customer.getId() + " has been updated");
		}else System.out.println("Data not updated");
		return customer;
	}
	
//	get customer by id
	public Customer getCustomerById(int id) {
		Customer customer = entityManager.find(Customer.class, id);
		if(customer != null) {
			System.out.println();
			System.out.println("----====::::](==-- Customer Detail --==)[::::====----");
			System.out.println();
			System.out.println("Customer ID is: " + customer.getId());
			System.out.println("Customer Name is: " + customer.getName());
			System.out.println("Customer Address is: " + customer.getAddrs());
			System.out.println("Customer Adhar No. is: " + customer.getAdhar_no());
			System.out.println("Customer status is: " + customer.getStatus());
		}
		else System.out.println("Customer ID dont exist");
		return customer;
	}
	
//	get all customer
	public List<Customer> getAllCustomer() {
		String sql = "SELECT customer FROM Customer customer";
		Query query = entityManager.createQuery(sql);
		List<Customer> c = query.getResultList();
		for(Customer customer : c) {
			System.out.println();
			System.out.println("----====::::](==-- Customer Detail --==)[::::====----");
			System.out.println();
			System.out.println("Customer ID is: " + customer.getId());
			System.out.println("Customer Name is: " + customer.getName());
			System.out.println("Customer Address is: " + customer.getAddrs());
			System.out.println("Customer Adhar No. is: " + customer.getAdhar_no());
			System.out.println("Customer status is: " + customer.getStatus());
		}
		return c;
	}
	
//	delete customer by id
	public void deleteCustomer(int id) {
		Customer customer = entityManager.find(Customer.class , id);
		entityTransaction.begin();
		entityManager.remove(customer);
		entityTransaction.commit();
		System.out.println("Customer with ID as " + id + " has been deleted");
	}
	
//	save account
	public Account saveAccount(int customer_id, Account account) {
		String sql = "SELECT account FROM Account account";
		Query query = entityManager.createQuery(sql);
		List <Account> acc = query.getResultList();
		for(Account account1 : acc) {			
			if(account1.getCustomer().getId() == customer_id) {
				System.out.println("Account with id as " + customer_id + " already exists");
				return null;
			}
		}
		Customer customer = entityManager.find(Customer.class , customer_id);
		if(customer != null) {
			if(customer.getStatus().equals("approved")) {
				account.setAcc_no(123456789 + customer.getId());
				account.setIfsc("BKID0001212");
				account.setBranch("Panvel");
				account.setBalance(10000);
				account.setCustomer(customer);
				entityTransaction.begin();
				entityManager.persist(account);
				entityTransaction.commit();
				System.out.println("Account has been added successfuly");
			}else System.out.println("You are not an approved Customer");
		}else System.out.println("Customer not found");
		return account;
	}
	
//	deposite money in account
	public Account depositeMoney(int customer_id, int account_id, double amount) {
		Customer customer = entityManager.find(Customer.class, customer_id);
		Account account = entityManager.find(Account.class , account_id);
		if(customer != null) {
			if(account != null) {
				if(customer.getStatus().equals("approved") && account.getCustomer().getId() == customer_id) {
					account.setBalance(account.getBalance() + amount);
					entityTransaction.begin();
					entityManager.merge(account);
					entityTransaction.commit();
				}
			} else System.out.println(account_id + " is invalid Customer's Account Id");
		} else System.out.println(customer_id + " is invalid Customer Id");
		return account;
	}
	
//	transfer money
	public Account transferMoney(int customer_id, int sender, int receiver, double transferAmount) {
		Customer customer = entityManager.find(Customer.class , customer_id);
		Account senderAccount = entityManager.find(Account.class , sender);
		Account receiverAccount = entityManager.find(Account.class , receiver);
		if(customer.getStatus().equals("approved") && senderAccount.getCustomer().getId() == customer_id) {
			if(senderAccount != null && receiverAccount != null) {
				if(senderAccount.getBalance() >= transferAmount) {
					senderAccount.setBalance(senderAccount.getBalance() - transferAmount);
					receiverAccount.setBalance(receiverAccount.getBalance() + transferAmount);
					entityTransaction.begin();
					entityManager.merge(senderAccount);
					entityManager.merge(receiverAccount);
					entityTransaction.commit();
				} else System.out.println("Account balance should be greater than transfer maount");
			} else System.out.println("No such account exists");
		} else System.out.println("You are not approved Customer");
		return receiverAccount;
	}
	
//	how many accounts does a customer has ?
//	get account by id
	public List<Account> getAccountById(int customer_id){
		String sql = "SELECT account FROM Account account";
		Query query = entityManager.createQuery(sql);
		List<Account> a = query.getResultList();
		for(Account account : a) {
			if(account.getCustomer().getId() == customer_id) {
				System.out.println();
				System.out.println("----====::::](==-- Account Detail --==)[::::====----");
				System.out.println();
				System.out.println("Account id is: " + account.getId());
				System.out.println("Account number is: " + account.getAcc_no());
				System.out.println("Bank branch name is: " + account.getBranch());
				System.out.println("Bank Ifsc code is: " + account.getIfsc());
				System.out.println("You bank balance is: Rs " + account.getBalance());
			}
		}
		return a;
	}
}