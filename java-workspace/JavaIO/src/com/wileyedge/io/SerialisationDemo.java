package com.wileyedge.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
@SuppressWarnings("serial")
class Address implements Serializable{
	private String country;
	private String city;
	public Address(String country, String city) {
		System.out.println("default");
		this.country = country;
		this.city = city;
	}
	public Address() {
		System.out.println("parameterized address");	
	}
	@Override
	public String toString() {
		return " [country=" + country + ", city=" + city + "]";
	}
	
}
@SuppressWarnings("serial")
class Student implements Serializable{
	private int rollno;
	private String name;
	private transient Address addr;
	
	public Student() {
		System.out.println("def");
	}
	public Student(int rollno, String name) {
		this.rollno = rollno;
		this.name  = name;
		System.out.println("par");

	}
	
	@Override
	public String toString() {
		return rollno+" "+name+" "+addr;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
}

public class SerialisationDemo {

	public static void main(String[] args) {
		
		Student s1 = new Student(1,"Dharani");
		Address a1 = new Address("Ind","Hyd");
		s1.setAddr(a1);
		File file = new File("D:\\C376\\student.ser");
		FileOutputStream fos=null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			
			oos = new ObjectOutputStream(bos);
			oos.writeObject(s1);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
