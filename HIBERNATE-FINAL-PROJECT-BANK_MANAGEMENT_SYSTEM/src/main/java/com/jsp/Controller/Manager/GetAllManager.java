package com.jsp.Controller.Manager;

import com.jsp.Service.ManagerService;

public class GetAllManager {
	public static void main(String[] args) {
		
		ManagerService managerService = new ManagerService();
		managerService.getAllManager();
	}

}
