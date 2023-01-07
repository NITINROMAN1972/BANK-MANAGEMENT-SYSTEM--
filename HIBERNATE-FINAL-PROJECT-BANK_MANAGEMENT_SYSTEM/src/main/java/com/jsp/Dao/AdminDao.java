package com.jsp.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.Dto.Admin;
import com.jsp.Dto.Manager;

public class AdminDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nitin");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
//	save admin
	public Admin saveAdmin(Admin admin) {
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		return admin;
	}
	
//	update admin
	public Admin updateAdmin(Admin admin) {
		Admin a = entityManager.find(Admin.class, admin.getId());
		if(admin.getName() != null) {
			a.setName(admin.getName());
		}
		if(admin.getEmail() != null) {
			a.setEmail(admin.getEmail());
		}
		if(admin.getPassword() != null) {
			a.setPassword(admin.getPassword());
		}
		if(a != null) {
			entityTransaction.begin();
			entityManager.merge(a);
			entityTransaction.commit();
			System.out.println("Admin with ID: " + admin.getId() + " is updated");
		}else System.out.println("Updation failed");
		return admin;
	}
	
//	get admin by id
	public Admin getAdminById(int id) {
		Admin admin = entityManager.find(Admin.class, id);
		if(admin != null) {
			System.out.println();
			System.out.println("----====::::](==-- Admin Detail --==)[::::====----");
			System.out.println();
			System.out.println("Admin ID is: " + admin.getId());
			System.out.println("Admin name is: " + admin.getName());
			System.out.println("Admin email is: " + admin.getEmail());
			System.out.println("Admin password is: " + admin.getPassword());
		}
		else System.out.println("Admin ID dont exist");
		return admin;
	}
	
//	get all admin
	public List<Admin> getAllAdmin() {
		String sql = "SELECT admin FROM Admin admin";
		Query query = entityManager.createQuery(sql);
		List<Admin> admin = query.getResultList();
		for(Admin admin1 : admin) {
			System.out.println();
			System.out.println("----====::::](==-- Admin Detail --==)[::::====----");
			System.out.println();
			System.out.println("Admin ID is: " + admin1.getId());
			System.out.println("Admin name is: " + admin1.getName());
			System.out.println("Admin email is: " + admin1.getEmail());
			System.out.println("Admin password is: " + admin1.getPassword());
		}
		return admin;
	}
	
//	delete admin by id
	public void deleteAdmin(int id) {
		Admin admin = entityManager.find(Admin.class , id);
		if(admin != null) {
			entityTransaction.begin();
			entityManager.remove(admin);
			entityTransaction.commit();
			System.out.println("Admin with ID as " + id + " has been deleted");
		} else System.out.println("invalid Admin id");
	}
	
//	approve admin
	public List<Admin> approveAdmin(int id, String email, String password) {
		String sql = "SELECT admin FROM Admin admin";
		Query query = entityManager.createQuery(sql);
		List<Admin> a = query.getResultList();
		for(Admin admin : a) {
			if(admin.getId()==id) {
				if(admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
					System.out.println("Admin logged in successfully");
					approveManager(id);
				}
				else {
					System.out.println("Email or Password did not matched");
				}
			}
		}
		System.out.println("Admin with this ID dont exists");
		return a;
	}
	
//	approve manager
	public List<Manager> approveManager (int id) {
		Admin admin = entityManager.find(Admin.class , id);
		List<Manager> manager = null;
		ManagerDao managerDao = new ManagerDao();
		manager = managerDao.getAllManager();
		for (Manager m : manager) {
			if (m.getStatus().equals("unapproved")) {
				m.setStatus("approved");
				m.setAdmin(admin);
				System.out.println("Manager has been approved");
				entityTransaction.begin();
				entityManager.merge(m);
				entityTransaction.commit();
			}
		}
		return manager;
	}
}