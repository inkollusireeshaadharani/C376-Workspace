package com.wileyedge.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "C")
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
