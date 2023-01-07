package com.jsp.Service;

import com.jsp.Dao.ManagerDao;
import com.jsp.Dto.Customer;
import com.jsp.Dto.Manager;

public class ManagerService {
	
//	save manager
	public Manager saveManager(Manager manager) {
		ManagerDao managerDao = new ManagerDao();
		return managerDao.saveManager(manager);
	}
	
//	update admin
	public Manager updateManager(Manager manager) {
		ManagerDao managerDao = new ManagerDao();
		return managerDao.updateManager(manager);
	}
	
//	get manager by id
	public Manager getManagerById(int id) {
		ManagerDao managerDao = new ManagerDao();
		return managerDao.getManagerById(id);
	}
	
//	get all manager
	public void getAllManager() {
		ManagerDao managerDao = new ManagerDao();
		managerDao.getAllManager();
	}
	
//	delete manager
	public void deleteManager(int id) {
		ManagerDao managerDao = new ManagerDao();
		managerDao.deleteManager(id);
	}
	
//	approve manager
	public void approveManager(Manager manager) {
		ManagerDao managerDao = new ManagerDao();
		managerDao.approveManager(manager);
	}
	
//	delete customer
	public Customer deleteCustomer(int manager_id, int customer_id) {
		ManagerDao managerDao = new ManagerDao();
		return managerDao.deleteCustomer(manager_id, customer_id);
	}
}