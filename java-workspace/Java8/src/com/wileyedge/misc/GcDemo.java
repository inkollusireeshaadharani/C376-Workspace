package com.wileyedge.misc;

class Employee{

	public void doCoding() {
		System.out.println("Employee is coding ");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("I am getting removed from the heap and now doing some clean up ");
	}
	
}

public class GcDemo {
	
	public void doWork() {
		Employee e1 = new Employee();
		e1.doCoding();
//		e1 = null;
	}
	
	public static void main(String[] args) {
		GcDemo demo = new GcDemo();
		demo.doWork();
		System.gc();//explicitly calling to make finalize() work
//		try {
//			Thread.sleep(15000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

}







