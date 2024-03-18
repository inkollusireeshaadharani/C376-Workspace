package com.wileyedge.singletable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wileyedge.utility.EntityManagerHelper;

public class SingleTableStrategy {

	public static void main(String[] args) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Employee e1 = new PermanentEmployee("Jane","Dane",923456);
		Employee e2 = new PermanentEmployee("Don","Draper",123456);
		Employee e3 = new ContractEmployee("Sara","inkollu","Wiley");
		Employee e4 = new ContractEmployee("Sekhar","inkollu","Edge");
		Employee e5 = new ContractEmployee("John","Doe","Wiley Edge");
		
		tx.begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		em.persist(e5);
		
		tx.commit();
	}

}
