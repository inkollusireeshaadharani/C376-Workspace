package com.emp;

import com.emp.utility.Address;

public class Employee {
	
	private int id;
	private String fname;
	private String lname;
	private Address addr;//addr is of type Address and instance variable of Employee class
	
	public Employee() {
		System.out.println("Employee object is being created");
	}
	
	public Employee(int id, String fname, String lname) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		System.out.println("Employee object is being created using Parameterized constructor");
	}
	
	public Employee(int id, String fname, String lname, Address addr) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.addr = addr;
		System.out.println("Employee object is being created using Parameterized constructor");
	}
	
	public Address getAddress() {
		return addr;
	}

	public void setAddress(Address address) {
		this.addr = address;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return  this.id + " " + this.fname + " " + this.lname + " " + this.addr;
	}
	
	
	
}
