package com.wileyedge.jointable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "perm6")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class PermanentEmployee extends Employee {
	private int pfAccountNumber;

	public int getPfAccountNumber() {
		return pfAccountNumber;
	}

	public void setPfAccountNumber(int pfAccountNumber) {
		this.pfAccountNumber = pfAccountNumber;
	}

	public PermanentEmployee(String fname, String lname, int pfAccountNumber) {
		super(fname, lname);
		this.pfAccountNumber = pfAccountNumber;
	}
	
}
