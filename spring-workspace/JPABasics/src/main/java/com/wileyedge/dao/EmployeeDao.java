package com.wileyedge.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wileyedge.model.Address;
import com.wileyedge.model.Employee;
import com.wileyedge.utility.EntityManagerHelper;

public class EmployeeDao implements IDao {

	@Override
	public int createEmployee(int id, String fname, String lname) {
		System.out.println("Inside create emp");
		Employee employee=new Employee();
//		employee is in transient state
		employee.setId(id);
		employee.setFname(fname);
		employee.setLname(lname);
		Address address=new Address("Bengaluru","560010");
		employee.setAddr(address);
		System.out.println("Going to call persist");
//		employee going in manager state
		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx=em.getTransaction();
//		start the transaction
		tx.begin();
		em.persist(employee);//		employee is in managed state
		System.out.println("After persist is called");
//		close transactoin
		tx.commit();
		return id;
	}

	@Override
	public boolean updateEmployee(int id, String newfname) {
		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Employee employee =em.find(Employee.class, id);// employee is in managed state
		if(employee==null)
			return false;
		
		employee.setFname(newfname);
		em.merge(employee);
		tx.commit();
		return true;
	}

	@Override
	public boolean removeEmployee(int id) {
		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Employee employee=em.find(Employee.class,id);
		if(employee==null)
			return false;
		em.remove(employee); // employee is in remove state
		tx.commit();
		return false;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
