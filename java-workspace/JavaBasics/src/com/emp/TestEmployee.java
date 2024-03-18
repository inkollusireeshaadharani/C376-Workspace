package com.emp;

import com.emp.utility.Address;

public class TestEmployee {

	public static void main(String[] args) {
		
		System.out.println("Welcome to java");
		
		
		Address a1 = new Address("India", "Hyderabad", 500074);
//		a1.setCountry("India");
//		a1.setCity("Hyderabad");
//		a1.setZip(500074);
		
		Address a2 = new Address("India", "Bengaluru", 500000);
//		a2.setCountry("India");
//		a2.setCity("Bangalore");
//		a2.setZip(400573);
		
		Employee e1 = new Employee(10,"Dharani","Inkollu",a1);
//		e1.setId(10);
//		e1.setFname("Dharani");
//		e1.setLname("Inkollu");
		
		Employee e2 = new Employee(20,"John","Doe",a2);
//		e2.setId(20);
//		e2.setFname("John");
//		e2.setLname("Doe");
		
//		e1.setAddress(a2);
//		e2.setAddress(a2);
		
		
//		System.out.println(e1.getId()+" "+e1.getFname()+" "+e1.getLname());
//		System.out.println(e2.getId()+" "+e2.getFname()+" "+e2.getLname());
//		
//		System.out.println(e1.getFname()+" "+e1.getAddress().getCity());
//		System.out.println(e2.getFname()+" "+e2.getAddress().getCity());
		
		System.out.println(e1);
		System.out.println(e2);
	}
}
