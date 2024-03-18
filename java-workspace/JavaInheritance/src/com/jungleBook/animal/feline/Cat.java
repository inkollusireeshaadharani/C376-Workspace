package com.jungleBook.animal.feline;

import com.jungleBook.animal.Animal;
import com.jungleBook.animal.Pet;

public class Cat extends Animal implements Pet{


	public Cat(String name, String color) {
		super(name,color);
		System.out.println("Inside parameterized constructor of Cat ");
	}
	
	//specific for each animal but not sleep
	@Override
	public void makeNoise() {
		System.out.println(this.name+" is meowing");
	}
	
	@Override
	public void play() {
		System.out.println(this.name+" is sitting on ur lap");
	}
	@Override
	public void beFriendly() {
		System.out.println(this.name+" is licking your hand");
	}
	
}
