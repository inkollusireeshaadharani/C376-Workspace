package com.operators;

public class OperatorDemo {
	
	public static boolean isPositive(int a) {
		System.out.println("In isPositive method");
		if(a<0) return false;
		else return true;
	}

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c = a++ + ++b;
		System.out.println("a = "+ a + " b = "+ b + " c = " + c);
		int x = -5;
		int y = -10;
		if(isPositive(x) && isPositive(y)) {
			System.out.println("both positive");
		}
		else {
			System.out.println("not positive");
		}
	}
	
}
