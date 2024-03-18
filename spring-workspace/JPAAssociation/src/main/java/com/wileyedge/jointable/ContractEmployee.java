package com.wileyedge.jointable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "contra6")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
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
