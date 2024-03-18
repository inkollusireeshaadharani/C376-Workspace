package com.jungleBook.animal;

public abstract class Animal {
	public String name;
	public String color;
	
	public Animal() {
		System.out.println("Inside default constructor of Animal ");
	}
	
	public Animal(String name, String color) {
		System.out.println("Inside parameterised constructor of Animal ");
		this.name = name;
		this.color = color;
	}
	
	public abstract void makeNoise();
	
	public void sleep() {
		System.out.println(this.name+" is sleeping.");
	}
}
