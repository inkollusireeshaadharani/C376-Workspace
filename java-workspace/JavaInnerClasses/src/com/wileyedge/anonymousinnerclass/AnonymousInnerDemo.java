package com.wileyedge.anonymousinnerclass;

interface Pet{
	void play();
	void beFriendly();
}

abstract class Animal{
	public abstract void makeNoise();
}

class Dog extends Animal implements Pet{

	@Override
	public void play() {
		System.out.println("Dog is Playing");
	}

	@Override
	public void beFriendly() {
		System.out.println("Dog is being friendly");
	}

	@Override
	public void makeNoise() {
		System.out.println("Dog is Barking");
	}
	
}

public class AnonymousInnerDemo {

	public static void main(String[] args) {
//		Animal a = new Dog();
//		Pet p = new Dog();
		Animal a2 = new Animal() {
			@Override
			public void makeNoise() {
				System.out.println("Tiger is Roaring");
			}
		};
		Pet p2 = new Pet() {
			@Override
			public void play() {
				System.out.println("Cat is jumping");
			}

			@Override
			public void beFriendly() {
				System.out.println("Cat is sitting on ur lap");
			}			
		};
		
		a2.makeNoise();
		p2.play();
		p2.beFriendly();
	}

}








