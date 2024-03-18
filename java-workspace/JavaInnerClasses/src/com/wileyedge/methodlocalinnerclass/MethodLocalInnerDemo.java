package com.wileyedge.methodlocalinnerclass;

public class MethodLocalInnerDemo {

	private int x = 10;
	
	public void outerMethod() {
		int y = 9;
		class MyInner{
			int z = 11;
			public void innerMethod() {
				System.out.println("From method local class I can access Outer's private 'x' "+x);
				System.out.println("From method local class accessing Inner's 'z' "+z);
				System.out.println("From method local class accessing Outer method's 'y' "+y);
			}//end of method innerMethod()
		}//end of class MyInner
		MyInner mi = new MyInner();
		mi.innerMethod();
	}//end of outerMethod()
	
	public static void main(String[] args) {
		MethodLocalInnerDemo demo = new MethodLocalInnerDemo();
		demo.outerMethod();
	}

}









