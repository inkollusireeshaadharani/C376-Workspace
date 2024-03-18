package com.wileyedge.jpql;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		IDao dao = new EmployeeDao();
		dao.createEmployee("Dharani", "Inkollu");
		dao.createEmployee("Don", "Draper");
		dao.createEmployee("John", "Doe");
		System.out.println("============ALL======");
		List<Employee> list1 = dao.getEmployees();
		list1.stream().forEach(System.out::println);
		
		System.out.println("=====GREATER THAN= X======");
		List<Employee> list2 = dao.getEmployeesWithIdGrX(2);
		list2.stream().forEach(System.out::println);
		
		System.out.println("=====NAMES======");
		List<String> list3 = dao.getEmployeeNames();
		list3.stream().forEach(System.out::println);
		
		System.out.println("=====X EMPLOYEES======");
		List<Employee> list4 = dao.getXEmployees(1, 2);
		list4.stream().forEach(System.out::println);
		
		System.out.println("============ALL USING NAMED QUERY======");
		List<Employee> list5 = dao.getEmployeesUsingNamedQuery();
		list5.stream().forEach(System.out::println);
		
		System.out.println("============ALL USING NAMED NATIVE QUERY======");
		List<Employee> list6 = dao.getEmployeesUsingNativeNamedQuery();
		list6.stream().forEach(System.out::println);
		
		System.out.println("============displayEmployeesByIdFnameUsingCriteria======");
		dao.displayEmployeesByIdFnameUsingCriteria(2,"Don");
	}

}
