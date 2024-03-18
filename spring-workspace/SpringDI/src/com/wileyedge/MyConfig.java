package com.wileyedge;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
//replacement for entire XML
@ComponentScan(basePackages = "com.wileyedge")
public class MyConfig {
	
	@Bean(name="a4")
	public Address getAddr1() {
		Address a = new Address(654321,"Jaipur","India");
		return a;
	}
	
	@Primary
	@Bean(name="a5")
	public Address getAddr2() {
		Address a = new Address(354321,"Benagluru","India");
		return a;
	}
	
	@Bean(name="a6")
	public Address getAddr3() {
		Address a = new Address(654321,"Chennai","India");
		return a;
	}
}
