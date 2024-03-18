package com.wileyedge.database;

public class TestEmployee {

	public static void main(String[] args) {
		try {
			//the class's static block will be called
			Class.forName("com.wileyedge.database.Employee");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Employee class not found");
		}
	}

}
