package com.jungleBook.animal.canine;

import com.jungleBook.animal.Animal;
import com.jungleBook.animal.Pet;

public class Dog extends Animal implements Pet {
	public Dog() {
//		super();
		this("Tommy","Black");
		System.out.println("Inside default constructor of Dog ");
	}
	public Dog(String name, String color) {
		super(name,color);
		System.out.println("Inside parameterized constructor of Dog ");
	}
	@Override
	public void makeNoise() {
		System.out.println(this.name+" is barking");
	}
	@Override
	public void play() {
		System.out.println(this.name+" is playing");
	}
	@Override
	public void beFriendly() {
		System.out.println(this.name+" is waving his tail");
	}
	
}
