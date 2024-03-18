package com.wileyedge.concurrency;

class Account{
	public int balance=0;
	public void withdraw(int amount) {
		balance -= amount;
	}
	public void deposit(int amount) {
		balance += amount;
	}
}

class Depositor implements Runnable{
	private Account acc;
	public Depositor(Account acc) {
		this.acc = acc;
	}
	
	@Override
	public void run() {
		synchronized(acc) {
			acc.deposit(100);
			acc.notifyAll();
		}
		
	}
}

class Withdrawer implements Runnable{
	private Account acc;
	public Withdrawer(Account acc) {
		this.acc = acc;
	}
	@Override
	public void run() {
		synchronized(acc) {
			try {
				acc.wait();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			acc.withdraw(100);
		}
		if(acc.balance < 0) {
			System.out.println("BIG PROBLEM");
		}
		else {
			System.out.println("Balance is never negative");
		}
	}
}

public class WaitNotifyDemo {

	public static void main(String[] args) {
		Account acct = new Account();

		Depositor dep = new Depositor(acct);
		Withdrawer wid = new Withdrawer(acct);
		
		Thread t1 = new Thread(dep);
		Thread t2 = new Thread(wid);
		
		t1.setName("Raj");
		t2.setName("Priya");
		
		t2.start();
		t1.start();
	}

}
