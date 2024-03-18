package com.wileyedge.inference;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MethodInferenceDemo {

	public static void main(String[] args) {
		//4 supported types of method inferences
//		//1. Constructor Reference with the syntax Class::new and using generics Class<T>:
		//2. Static method reference with the syntax Class::static_method
		//3. Instance method of arbitrary object of specific type with the syntax
		//	 Class::method
		//4. Instance method of particular object of specific type with instance::method
		
		//without lambda
		Car c1 = Car.create(new Supplier<Car>() {

			@Override
			public Car get() {
				return new Car();
			}
			
		});
		
		//with lambda
		Car c2 = Car.create(()->new Car());
		
		//with method inference
		Car c3 = Car.create(Car::new);
		
		MySupplier<Car> mysup = Car::new;
		Car c4 = Car.create1( mysup,"Maruti" );
		
		MySupplier<Car> mysup1 = Car::new;
		Car c5 = Car.create1( mysup1,"Audi" );
		
		MySupplier<Car> mysup2 = Car::new;
		Car c6 = Car.create1( mysup2,"Rolls Royce" );
		
		List<Car> cars = new ArrayList<Car>();
		
		cars.add(c4); 
		cars.add(c5);
		cars.add(c6);
		
		//without lambda
		
		cars.forEach(new Consumer<Car>() {

			@Override
			public void accept(Car t) {
				Car.doServicing(t);
			}
			
		});
		
		//with lambda
		cars.forEach((car)-> Car.doServicing(car));
		
		//with static method inference
		//doServicing(car)
		cars.forEach(Car::doServicing);
		
		//with instance method inference
		
		//calling drive on each car
		//cuz forEach consumes single car each time
		//method also takes single car
		//car.drive()
		cars.forEach(Car::drive);
		
		//with instance method inference on particular object
		//calling follow on police passing each car
		//police.follow(car)
		final Car police = Car.create( Car::new );
		cars.forEach( police::follow );
		
	}

}
