package com.wileyedge.defaultandstatic;

public class DefaultAndStaticMethodsDemo {

	public static void main(String[] args) {
		Writable1 w1 = new WritableImpl();
		
		w1.abc();
		//methods coming from parent
		w1.write1();
		w1.write2();
		//static
		Writable1.pqr();
		Writable2.pqr();

	}

}
