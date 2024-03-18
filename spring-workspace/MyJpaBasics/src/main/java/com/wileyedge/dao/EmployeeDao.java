package com.wileyedge.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wileyedge.model.Employee;
import com.wileyedge.utility.EntityManagerHelper;

public class EmployeeDao implements IDao {

	@Override
	public int createEmployee(int id, String fname, String lname) {
		Employee e = new Employee();//e is in Transient state
		e.setFname(fname);
		e.setLname(lname);
		EntityManager em = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(e);
		tx.commit();//e is in Managed state
		return id;
	}

	@Override
	public boolean updateEmployee(int id, String newfname) {
		
		return false;
	}

	@Override
	public boolean removeEmployee(int id) {
		
		return false;
	}

	@Override
	public List<Employee> getEmployees() {
		
		return null;
	}

}
