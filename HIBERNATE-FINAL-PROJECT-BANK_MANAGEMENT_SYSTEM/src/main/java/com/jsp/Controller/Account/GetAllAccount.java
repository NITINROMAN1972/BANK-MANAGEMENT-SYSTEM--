package com.jsp.Controller.Account;

import com.jsp.Dao.AccountDao;

public class GetAllAccount {
	public static void main(String[] args) {
		
		AccountDao accountDao = new AccountDao();
		accountDao.getAllAccount();
	}
}