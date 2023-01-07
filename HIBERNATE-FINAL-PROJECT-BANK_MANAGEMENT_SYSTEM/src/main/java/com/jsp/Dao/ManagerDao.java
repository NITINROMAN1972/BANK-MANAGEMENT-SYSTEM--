package com.jsp.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.Dto.Customer;
import com.jsp.Dto.Manager;

public class ManagerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nitin");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
//	save manager
	public Manager saveManager(Manager manager) {
		manager.setStatus("unapproved");
		System.out.println("Please wait for the Admin to approve Manager");
		entityTransaction.begin();
		entityManager.persist(manager);
		entityTransaction.commit();
		return manager;
	}
	
//	update manager
	public Manager updateManager(Manager manager) {
		Manager m = entityManager.find(Manager.class, manager.getId());
		if(manager.getName() != null) {
			m.setName(manager.getName());
		}
		if(manager.getEmail() != null) {
			m.setEmail(manager.getEmail());
		}
		if(manager.getPassword() != null) {
			m.setPassword(manager.getPassword());
		}
		if(m != null) {
			entityTransaction.begin();
			entityManager.merge(m);
			entityTransaction.commit();
			System.out.println("Manager with ID as "+ manager.getId() + " has been updated");
		}else System.out.println("Data not updated");
		return manager;
	}
	
//	get manager by id
	public Manager getManagerById(int id) {
		Manager manager = entityManager.find(Manager.class, id);
		if(manager != null) {
			System.out.println();
			System.out.println("----====::::](==-- Manager Detail --==)[::::====----");
			System.out.println();
			System.out.println("Manager ID is: " + manager.getId());
			System.out.println("Manager name is: " + manager.getName());
			System.out.println("Manager email is: " + manager.getEmail());
			System.out.println("Manager password is: " + manager.getPassword());
			System.err.println("Manager status is: " + manager.getStatus());
		}
		else System.out.println("Manager ID dont exist");
		return manager;
	}
	
//	get all manager
	public List<Manager> getAllManager() {
		String sql = "SELECT manager FROM Manager manager";
		Query query = entityManager.createQuery(sql);
		List<Manager> manager = query.getResultList();
		for(Manager m : manager) {
			System.out.println();
			System.out.println("----====::::](==-- Manager Detail --==)[::::====----");
			System.out.println(m.getId());
			System.out.println(m.getName());
			System.out.println(m.getEmail());
			System.out.println(m.getPassword());
			System.out.println(m.getStatus());
		}
		return manager;
	}
	
//	delete manager by id
	public void deleteManager(int id) {
		Manager manager = entityManager.find(Manager.class , id);
		entityTransaction.begin();
		entityManager.remove(manager);
		entityTransaction.commit();
		System.out.println("Manager with ID as " + id + " has been deleted");
	}
	
//	approve manager
	public List<Manager> approveManager(Manager manager) {
		String sql = "SELECT manager FROM Manager manager";
		Query query = entityManager.createQuery(sql);
		List<Manager> m = query.getResultList();
		for(Manager manager1 : m) {
			if(manager1.getId() == manager.getId()) {
				if(manager1.getEmail().equals(manager.getEmail()) && manager1.getPassword().equals(manager.getPassword())) {
					System.out.println("Manager logged in successfully");
					approveCustomer(manager.getId());
				}
				else {
					System.out.println("Email or Password did not matched");
				}
			}
		}
		return m;
	}
	
//	approve customer
	public List<Customer> approveCustomer (int id) {
		Manager manager = entityManager.find(Manager.class , id);
		List<Customer> customer = null;
		CustomerDao customerDao = new CustomerDao();
		customer = customerDao.getAllCustomer();
			for (Customer c : customer) {
				if (c.getStatus().equals("unapproved")) {
					c.setStatus("approved");
					c.setManager(manager);
					System.out.println("Customer has been approved");
					entityTransaction.begin();
					entityManager.merge(c);
					entityTransaction.commit();
				}
			}
		return customer;
	}
	
//	delete customer by id
	public Customer deleteCustomer(int manager_id, int customer_id) {
		Manager manager = entityManager.find(Manager.class , manager_id);
		Customer customer = entityManager.find(Customer.class , customer_id);
		if(manager != null) {
			if(customer != null) {
				if(customer.getManager().getId() == manager_id) {
					entityTransaction.begin();
					entityManager.remove(customer);
					entityTransaction.commit();
					System.out.println("Customer has been removed");
				} else System.out.println(customer.getName() + " is not your customer");
			} else System.out.println("Invalid Customer id");
		} else System.out.println("Invalid Manager id");
		return customer;
	}
}