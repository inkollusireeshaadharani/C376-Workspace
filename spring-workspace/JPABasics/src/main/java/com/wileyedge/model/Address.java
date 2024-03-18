package com.wileyedge.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//@Embeddable
public class Address {
		@Column(name="city", nullable = false)
		private String city;
		@Column(name = "zip", nullable = false)
		private String zip;
		
		public Address() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Address(String city, String zip) {
			super();
			this.city = city;
			this.zip = zip;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getZip() {
			return zip;
		}
		public void setZip(String zip) {
			this.zip = zip;
		}

		@Override
		public String toString() {
			return "Address [city=" + city + ", zip=" + zip +"]";
		}		
		
		
}
