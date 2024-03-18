package com.wileyedge;

import com.wileyedge.dao.EmployeeDao;
import com.wileyedge.dao.IDao;

public class Main {
	public static void main(String []args) {
		IDao dao=new EmployeeDao();
		dao.createEmployee(100, "Shanvi", "Kumari");
//		dao.createEmployee(101, "Stuti", "Inkollu");
//		dao.updateEmployee(100, "Shravya");
		
//		dao.removeEmployee(100);
	}
}
