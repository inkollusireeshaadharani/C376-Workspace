package com.exp;

//Exception -- checked
//RuntimeException extended -- no need to compulsarily handle
public class InsufficientFundsException extends Exception {
	
	public InsufficientFundsException(String message) {
		super(message);
	}

}
