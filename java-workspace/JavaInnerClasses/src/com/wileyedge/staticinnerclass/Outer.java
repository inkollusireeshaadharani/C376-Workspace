package com.wileyedge.staticinnerclass;

public class Outer {
	
	static class Inner{
		public void innerMethod() {
			System.out.println("Hi from innerMethod()");
		}
	}
	
	public static void main(String[] args) {
		Outer.Inner in = new Outer.Inner();
		in.innerMethod();
	}

}
