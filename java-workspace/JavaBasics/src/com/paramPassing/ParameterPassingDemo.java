package com.paramPassing;

class Num{
	public int n;//instance variable of type n
}

public class ParameterPassingDemo {

	public void modify(int n) {
		System.out.println("inside modify(int) method");
		n=10;
		System.out.println("exiting modify(int) method "+n);
	}
	
	public void modify(Num num) {
		System.out.println("inside modify(Num) method");
		num.n=10;
		System.out.println("exiting modify(Num) method "+num.n);
	}
	
	public void modify(String str) {
		System.out.println("inside modify(str) method");
		str = "10";
		System.out.println("exiting modify(str) method "+str);
	}
	
	public static void main(String[] args) {
		System.out.println("inside main method");
		
		int n = 5;
		System.out.println("before invoking modify method "+n);
		ParameterPassingDemo p = new ParameterPassingDemo();
		p.modify(n);	
		System.out.println("after invoking modify method "+n);
		
		Num num = new Num();
		num.n = 5;
		System.out.println("before invoking modify method "+num.n);
		p.modify(num);
		System.out.println("after invoking modify method "+num.n);
		
		String str = "5";
		System.out.println("before invoking modify method "+str);
		p.modify(str);
		System.out.println("after invoking modify method "+str);
		
		System.out.println("exiting main method");
		
		
	}

}
