package com.exp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionDemo {
	
	public void method3() {
		System.out.println("Inside method3");
		BankAccount acct = new BankAccount();
		try {
			acct.withdraw(120);
		} 
		catch (InsufficientFundsException e) {
			e.printStackTrace();
			System.out.println("Try to withdraw lesser amount");
		}
		System.out.println("Exiting method3");
	}
	
	public void method2() throws FileNotFoundException{
		System.out.println("Inside method2");

		FileInputStream fis = new FileInputStream("D:\\C376\\abc.txt");

		System.out.println("Exiting method2");
//		try {	
//		}
//		catch(FileNotFoundException e) {
//			System.out.println("File not found");
//		}
//		
//		finally {	
//			fis.close();
//			System.out.println("Gets executed always");
//		}
		
	}
	
	public void method1(int a) {
		System.out.println("Inside method1");
		try {
			System.out.println("Going to divide");
			int r = 10/a;
			System.out.println("Divided"+r);
		}
		catch(ArithmeticException | NullPointerException e) {
			System.out.println("Please don't divide by zero");
		}
		catch(Exception e) {
			System.out.println("Please don't divide by zero");
		}
		finally {
			System.out.println("Gets executed always");
		}
		
		System.out.println("Exiting method1");
	}
	public static void main(String[] args) {
		
		System.out.println("Inside Main");
		ExceptionDemo demo = new ExceptionDemo();
//		demo.method1(2);
//		try {
//			demo.method2();
//		}
//		catch(FileNotFoundException e) {
//			
//		}
		demo.method3();
		System.out.println("Exiting Main");
	}

}
