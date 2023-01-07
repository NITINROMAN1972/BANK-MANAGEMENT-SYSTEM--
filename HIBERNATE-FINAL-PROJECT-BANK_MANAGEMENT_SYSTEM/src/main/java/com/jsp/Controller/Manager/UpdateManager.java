package com.jsp.Controller.Manager;

import com.jsp.Dto.Manager;
import com.jsp.Service.ManagerService;

public class UpdateManager {
	public static void main(String[] args) {
		
		Manager manager = new Manager();
		manager.setId(6);
		manager.setEmail("neeta@mylove");
		
		ManagerService managerService = new ManagerService();
		managerService.updateManager(manager);
	}
}