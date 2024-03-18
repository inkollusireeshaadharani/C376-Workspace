package com.wileyedge.misc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person{
	private String fname;
	private String lname;
	
	public Person(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}
	public Person() {
		super();
	}	
	public String getDescription() {
		return "Info about a person";
	}
}


public class ReflectionDemo {

	public static void main(String[] args) {
		Person  p = new Person();
		Class class1 = p.getClass();
		System.out.println("-------printing all constructors------");
		Constructor[] cons = class1.getConstructors();
		for(Constructor c : cons)
		{
			System.out.println(c);
		}
		System.out.println("-------printing all methods---------");
		Method[] meth = class1.getMethods();
		for(Method m : meth)
		{
			System.out.println(m.getName());
		}
		System.out.println("-------printing all attributes---------");
		Field[] fields = class1.getFields();
		for(Field f : fields)
		{
			System.out.println(f);
		}
		
	}

}
