package com.wileyedge;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//its like replacement of the entry <bean id="a3" class="com.wileyedge.Address">

@Component(value="a3")
public class Address {
//	@Value("100000")
	private int zip;
//	@Value("Hyderabad")
	private String city;
//	@Value("India")
	private String country;
	public Address() {
		System.out.println("Inside default constructor of Address");		

	}
	public Address(int zip, String city, String country) {
		super();
		this.zip = zip;
		this.city = city;
		this.country = country;
		System.out.println("Inside paramterized constructor of address");
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
		System.out.println("Inside setZip()");		

	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
		System.out.println("Inside setCity()");	
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
		System.out.println("Inside setCountry()");	
	}
	@Override
	public String toString() {
		return "Address [zip=" + zip + ", city=" + city + ", country=" + country + "]";
	}
	
	
	
	
}
