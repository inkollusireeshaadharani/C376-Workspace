package com.wileyedge.lambda;

import java.util.*;

class Employee{
	private String name;
	private int age;
	private double salary;
	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
}

public class Exercise {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
			    new Employee("John", 35, 60000.0),
			    new Employee("Mary", 39, 70000.0),
			    new Employee("Jane", 42, 45000.0),
			    new Employee("Bill", 28, 55000.0),
			    new Employee("Tom", 31, 52000.0)
			);
//		We want to filter the list based on the following criteria:
//			Only include employees with a salary greater than 50000.
//			Only include employees who are under 40 years old.
//			Sort the resulting list by name in ascending order.
		
		employees.stream().filter(e -> e.getSalary()>50000 && e.getAge()<40)
		.sorted((e1,e2)-> e1.getName().compareTo(e2.getName())).forEach(System.out::println);
		
	}

}
