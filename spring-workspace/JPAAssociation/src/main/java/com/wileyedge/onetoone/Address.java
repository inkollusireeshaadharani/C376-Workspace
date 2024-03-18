package com.wileyedge.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="addr1")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private String city;
	@Column
	private int zip;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int id, String city, int zip) {
		super();
		this.id = id;
		this.city = city;
		this.zip = zip;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public Address(String city, int zip) {
		super();
		this.city = city;
		this.zip = zip;
	}
	
	
	
	
	
	

}
