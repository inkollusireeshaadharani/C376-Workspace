package com.jungleBook;

import com.jungleBook.animal.Animal;
import com.jungleBook.animal.Pet;
import com.jungleBook.animal.canine.Dog;
import com.jungleBook.animal.feline.Cat;

public class TestAnimal {
	public static void main(String[] args) {
//		Animal a = new Animal();
		Animal a = new Cat("Brulee","Black");
//		a.name = "Dog";
//		a.color="White";
		a.makeNoise();
		a.sleep();
		//shapes--calculate area
		Animal[] ani = new Animal[4];
		ani[0]=new Dog("Tommy","Black");
		ani[1]=new Cat("Tom","White");
		ani[2]=new Dog("Sweety","Orange");
		ani[3]=new Cat("May","Blue");
		for(Animal an : ani) {
			an.makeNoise();
			an.sleep();
		}
		Pet[] prr = new Pet[4];
		prr[0]=new Dog("Hero","Shiny brown");
		prr[1]=new Cat("Billy","White");
		prr[3]=new Dog("Shiro","Shiny brown");
		prr[2]=new Cat("Chopper","White");
		for(Pet p : prr) {
			p.beFriendly();
			p.play();
		}
		
		Pet p = new Pet() {

			@Override
			public void play() {
				System.out.println("Playing inside anonymous inner class");
			}

			@Override
			public void beFriendly() {
				System.out.println("Friendly inside anonymous inner class");
			}
			
		};
		
		p.play();
		p.beFriendly();
		
		Animal anim = new Animal() {

			@Override
			public void makeNoise() {
				System.out.println("Anonymous child class making noise");
			}
			
		};
		anim.makeNoise();
	}
}









