package com.wileyedge.firstbootdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="e1")
public class Employee {
	
	@Value("101")
	private int id;
	
	@Value("Dharani")
	private String name;
	
	public Employee() {
		System.out.println("Inside default Employee()");
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
}
