package com.wileyedge.tableperclass;

import javax.persistence.Entity;

@Entity(name = "contra5")
public class ContractEmployee extends Employee {
	private String contractorName;

	public String getContractorname() {
		return contractorName;
	}

	public void setContractorname(String contractorname) {
		this.contractorName = contractorname;
	}

	public ContractEmployee(String fname, String lname, String contractorName) {
		super(fname, lname);
		this.contractorName=contractorName;
	}
	
}
