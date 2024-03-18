package com.wileyedge;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//its like replacement of the entry <bean id="e3" class="com.wileyedge.Employee">
@Component(value="e3")
public class Employee implements BeanNameAware, ApplicationContextAware{
	@Value("30")
	private int id;
	@Value("Peggy")
	private String fname;
	@Value("Olson")
	private String lname;
	@Autowired
//	@Qualifier(value = "a4")
	private Address addr;
	private ApplicationContext context;
	
	@Override
	public void setBeanName(String beanName) {
		System.out.println("inside setBeanName() of Employee & beanName is "+beanName);
	}
	

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		System.out.println("inside setApplicationContext() of Employee & context is "+context);
//		this.addr = context.getBean("a2",Address.class);
		this.context = context;
	}
//, InitializingBean
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		this.fname = "Betty";
//		this.addr = context.getBean("a2",Address.class);
//	}
	
	
	public void myInit() {
		this.fname = "Betty";
//		this.addr = context.getBean("a2",Address.class);
	}
	public void myDestroy() {
		System.out.println("Inside myDestroy()");
		this.addr = null;
		
	}
	
	
	public Employee(int id, String fname, String lname, Address addr) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.addr = addr;
		System.out.println("Inside param constructor of Employee");		

	}

	public Employee() {
		System.out.println("Inside default constructor of Employee");		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		System.out.println("Inside setter of ID");
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
		System.out.println("Inside setter of fname");
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
		System.out.println("Inside setter of lname");
	}

	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", addr=" + addr.toString() + "]";
	}

	public Address getAddr() {
		return addr;
	}

	
	public void setAddr(Address addr) {
		this.addr = addr;
		System.out.println("Inside setAddr()");
	}




	
}
