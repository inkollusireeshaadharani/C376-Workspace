package com.wileyedge.regularinnerclass;

public class Outer {
	
	private int x = 10;
	public class Inner{
		public void method1() {
			System.out.println("I can access private variable x of Outer in Inner class "+x);
		}
	}
	
	public static void main(String[] args) {
		Outer outer = new Outer();
		Inner in = outer.new Inner();
		in.method1();
	}

}
