package com.wileyedge;

import com.wileyedge.dao.EmployeeDao;
import com.wileyedge.dao.IDao;

public class Main {
	public static void main(String[] args) {
		IDao dao = new EmployeeDao();
		dao.createEmployee(0, "Dharani", "Inkollu");
		dao.createEmployee(0, "Deepika", "Inkollu");
		
	}
}
