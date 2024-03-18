package com.wileyedge.concurrency;

//class Job extends Thread{
class Job1 implements Runnable{
	@Override
	public void run() {
		method2();
	}
	
	public void method2() {
		//gets current executing thread
		String name = Thread.currentThread().getName();
		
		for(int j = 1000;j<2000;j++) {
			System.out.println(name+" "+j);
			try {
				Thread.sleep(2000);
				//useful in apps involving pulling or
				//continuously fetching
				//for every second
				//sleep for some time 
				//then fetch
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class Job2 implements Runnable{
	@Override
	public void run() {
		method1();
	}
	

	public void method1() {
		String name = Thread.currentThread().getName();
		for(int i = 0;i<1000;i++) {
			System.out.println(name+" "+i);
//			method2();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ConcurrencyDemo extends Thread {
	
	
	
	public static void main(String[] args) {
		ConcurrencyDemo demo = new ConcurrencyDemo();
//		Thread t1 = new Thread(demo);
		
//		Thread t1 = new ConcurrencyDemo();
//		dunno why we didnt do this
//		maybe cuz we calling method1 on demo
//		check documentation

//		Job1 job1Demo = new Job1();
//		Thread t1 = new Thread(job1Demo);
//		t1.start();
		
		Job1 job1Demo = new Job1();
		Thread t1 = new Thread(job1Demo);
		Job2 job2Demo = new Job2();
		Thread t2 = new Thread(job2Demo);

		t1.setName("thread 1");
		t2.setName("thread 2");
		
		
		t1.start();
		t2.start();
//		demo.method1();
//		demo.method2();
	}

}
