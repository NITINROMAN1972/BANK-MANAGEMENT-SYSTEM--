package com.jsp.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.Dto.Account;

public class AccountDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nitin");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
//	save account
	public Account saveAccount(Account account) {
		account.setBalance(10000);
		entityTransaction.begin();
		entityManager.persist(account);
		entityTransaction.commit();
		return account;
	}
	
//	update account
	public Account updateAccount(Account account) {
		Account a = entityManager.find(Account.class, account.getId());
		if(account.getAcc_no() != 0.0) {
			a.setAcc_no(account.getAcc_no());
		}
		if(account.getBranch() != null) {
			a.setBranch(account.getBranch());
		}
		if(account.getBalance() != 0.0) {
			a.setBalance(account.getBalance());
		}
		if(account.getIfsc() != null) {
			a.setIfsc(account.getIfsc());
		}		
		if (a != null) {
			entityTransaction.begin();
			entityManager.merge(a);
			entityTransaction.commit();
			System.out.println("Account updated successfuly");
		}else System.out.println("Data not updated");
		return account;
	}
	
//	get account by id
	public Account getAccountById(int id) {
		Account account = entityManager.find(Account.class , id);
		if(account != null) {
			System.out.println();
			System.out.println("----====::::](==-- Account Detail --==)[::::====----");
			System.out.println();
			System.out.println("Account id is: " + account.getId());
			System.out.println("Account number is: " + account.getAcc_no());
			System.out.println("Bank branch name is: " + account.getBranch());
			System.out.println("Bank Ifsc code is: " + account.getIfsc());
			System.out.println("You bank balance is: Rs " + account.getBalance());
		}else System.out.println("Account id dont exists");
		return account;
	}
	
//	get all accounts
	public List<Account> getAllAccount() {
		String sql = "SELECT account FROM Account account";
		Query query = entityManager.createQuery(sql);
		List<Account> account = query.getResultList();
		for(Account a : account) {
			System.out.println();
			System.out.println("----====::::](==-- Account Detail --==)[::::====----");
			System.out.println();
			System.out.println("Account id is: " + a.getId());
			System.out.println("Account number is: " + a.getAcc_no());
			System.out.println("Bank branch name is: " + a.getBranch());
			System.out.println("Bank Ifsc code is: " + a.getIfsc());
			System.out.println("You bank balance is: Rs" + a.getBalance());
		}
		return account;
	}
}