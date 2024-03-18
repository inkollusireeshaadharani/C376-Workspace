package com.wileyedge.concurrency;

class Education implements Runnable{

	@Override
	public void run() {
		System.out.println("Education has started");
		
		//some time taken to complete education
		System.out.println("Education is going on");
		try {
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Education is completed");
	}
	
}
class Marriage implements Runnable{
	private Thread t;
	
	public Marriage(Thread t) {
		this.t = t;
	}

	@Override
	public void run() {
		//if below join stmt isnt present 
		//both threads execute simultaneously
		try {
			//one obj of thread is calling this on another thread
			//sleep is static
			//inside run method if we use sleep
			//current thread is running since we are in run method
			//therefore current thread is sleeping
			//marriage thread is joining at the end of education thread
			//Thread.currentThread().join();
			//Thread.currentThread() means marriage thread
			//above stmt means i will join when i complete
			//infinite loop
			t.join();
		} 
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("Wedding ceremony has started");
		System.out.println("Got married");	
	}
	
}
public class JoiningDemo {
	public static void main(String[] args) {
		Education e = new Education();
		Thread t1 = new Thread(e);

		Marriage m = new Marriage(t1);
		Thread t2 = new Thread(m);
		
		t1.start();
		t2.start();
	}
}
