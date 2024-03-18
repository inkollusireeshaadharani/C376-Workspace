package com.exp;

public class BankAccount {
	private int balance = 100;
	//should declare and not handle here itself
	//cuz calling person may handle it their own way
	//each person can handle their own way
	public void withdraw(int amount) throws InsufficientFundsException {
		if(amount<balance) {
			balance = balance - amount;
		}
		//default constructor is not available;
		//throwing based on a condition, using throw keyword
		//throws -- may throw exception
		//throws -- declaring
		//throw -- actually throwing
		else {
			InsufficientFundsException ife = new InsufficientFundsException("Insufficient money");
			throw ife;
		}
	}
}
