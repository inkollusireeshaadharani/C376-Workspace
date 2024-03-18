package com.wileyedge.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wileyedge.utility.EntityManagerHelper;

public class OneToMany {

	public static void main(String[] args) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employee e1 = new Employee("dharani","inkollu");
		Employee e2 = new Employee("deepika","inkollu");
		Employee e3 = new Employee("sara","inkollu");
		
		List<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		Department d1 = new Department("Java_Dept");
		d1.setEmployees(list);
		
		List<Employee> list2 = new ArrayList<>();
		list2.add(new Employee("Raj","Sharma"));
		list2.add(new Employee("Sekhar","Sharma"));
		Department d2 = new Department("Python_Dept");
		d2.setEmployees(list2);
		
		em.persist(d1);
		em.persist(d2);
		tx.commit();
	}

}
