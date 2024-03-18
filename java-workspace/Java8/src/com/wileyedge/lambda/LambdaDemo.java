package com.wileyedge.lambda;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;


@FunctionalInterface
interface Greetable{
	//public abstract by default
	String greet(String name);	
}

interface Addable{
	int add(int a,int b);
}

class AddableImpl implements Addable{

	@Override
	public int add(int a, int b) {
		return a + b;
	}
	
}

class GreetableImpl implements Greetable{

	@Override
	public String greet(String name) {
		System.out.println("Inside child class GreetableImpl");
		return "Welcome "+name;
	}
	
}

class Student implements Comparable<Student>{
	
	private int rollno;
	private String name;
	//constructors
	public Student(int rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}
	//getters and setters
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//object class methods
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		return this.rollno;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student s=(Student) obj;
			if(this.rollno==s.rollno && this.name.equals(s.name))
				return true;
		}
		return false;
	}
	
	@Override
	public int compareTo(Student s) {
		if(this.rollno < s.rollno) {
			return -1;
		}
		else if(this.rollno == s.rollno) {
			return 0;
		}
		else {
			return 1;
		}
		//below stmt wont work for int
		//return this.getRollno().compareTo(s.getRollno());
	}
	
	
}
//Main class
public class LambdaDemo {
	
	public void useLambdaInForLoop() {
		List<String> list = new ArrayList<>();
		list.add("Dharani");
		list.add("Deep");
		list.add("Sara");
		list.add("Sekhar");
		
		
		Consumer<String> c1 = new Consumer<>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}	
		};
//		list.forEach(c1);
		
		list.forEach((t) ->System.out.println(t));
		
		for(int i = 0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	public void useLambdaInThreading() {
		Runnable r = new Runnable() {

			@Override
			public void run() {
				
			}
			
		};
		
//		Runnable r2 = () -> System.out.println("Thread is spawned");
		
		Thread t1 = new Thread(() -> System.out.println("Thread is spawned"));
		t1.start();
	}

	public void useLambdaInCollection() {
		List<Student> list = new ArrayList<>();
		list.add(new Student(10,"Rob"));
		list.add(new Student(5,"Garry"));
		list.add(new Student(15,"Adam"));
		
		Comparator<Student> com1 = new Comparator<>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.getName().compareTo(s2.getName());
			}				
		};
//		Collections.sort(list,com1);
		
		Consumer<Student> cons1 = new Consumer<>() {
			@Override
			public void accept(Student stud) {
				System.out.println(stud);
			}			
		};
		list.forEach(cons1);
		
		Collections.sort(list,(s1,s2) -> s1.getName().compareTo(s2.getName()));
		list.forEach((stud)->System.out.println(stud));
		
		System.out.println("=======Reversed========");
		Collections.sort(list,com1.reversed());
		//reversed is a  default method inside comparator interface
		list.forEach((stud)->System.out.println(stud));
		
		System.out.println("=======Reverse order on rollno========");
		Comparator<Student> comp2 = Comparator.reverseOrder();
		Collections.sort(list,comp2);
//		Collections.sort(list,Comparator.reverseOrder());
		list.forEach((stud)->System.out.println(stud));
		
		//stream() returns Stream<Student>
		//some intermediate operations and terminal operation
		Stream<Student> filteredData = list.stream().filter(s -> s.getRollno()>5);
		System.out.println("Number of students with roll>5 "+filteredData.count());
		
	}
//-------------------------------------------------------------------	
	public void doBinaryOperations() {
		List<Integer> numbers = Arrays.asList(20, 10);
		//Binary operator on Integer
		BinaryOperator<Integer> binop1 = new BinaryOperator<>() {
			//if i didn't say <Integer> 
			//apply will accept Objects
			@Override
			public Integer apply(Integer t, Integer u) {
				return t + u;
			}			
		};
		BinaryOperator<Integer> binop2 = (t,u) -> t+u;
		int result1 = performBinaryOp(numbers,(i,j)->i+j);
		int result2 = performBinaryOp(numbers,(i,j)->i-j);
		System.out.println(result1);
		System.out.println(result2);
	}
	
	private int performBinaryOp(List<Integer> numbers,BinaryOperator<Integer> bin) {
		return bin.apply( numbers.get(0), numbers.get(1) );
	}
//-------------------------------------------------------------------
	public void doBehaviourPassing() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int res1 = sumAll(numbers);
		int res2 = sumAllEven(numbers);
		System.out.println(res1);
		System.out.println(res2);
		
		Predicate<Integer> p = new Predicate<>() {
			@Override
			public boolean test(Integer t) {
				if(t%2==0) return true;
				return false;
			}		
		};
		System.out.println("============== predicate SUM ALL================");
		System.out.println(sumAll(numbers,p));
		System.out.println(sumAll(numbers,(t)-> t%2==0));
		System.out.println(sumAll(numbers,(t)-> t>3));
		System.out.println(sumAll(numbers,(t)-> true));
	}
	private int sumAll(List<Integer> numbers,Predicate<Integer> p) {
		//Predicate has method test() accepts generic type
		//here p is integer
		//so test accepts integer
		//returns boolean
		int total = 0;
		for(int num : numbers) {
			//Polymorphism
			//child's test method is called
			//diff test method for each object
			if(p.test(num)) {
				total+=num;
			}
		}
		return total;
	}
	private int sumAll(List<Integer> numbers) {
		int total = 0;
		for(int num : numbers) {
			total += num;
		}
		return total;
	}
	
	private int sumAllEven(List<Integer> numbers) {
		int total = 0;
		for(int num : numbers) {
			if(num%2==0){	
				total += num;	
			}
		}
		return total;
	}
	

	public static void main(String[] args) {
		
		Greetable gt1 = new GreetableImpl();
		System.out.println( gt1.greet("Jyothsna once"));
		
		
		Greetable gt2 = new Greetable() {

			@Override
			public String greet(String name) {
				System.out.println("Inside anonymous inner class GreetableImpl");
				return "Welcome "+name;
			}
			
		};
		
		System.out.println( gt2.greet("Jyothsna twice"));
		
		
		Greetable gt3 = name -> "Welcome "+name;
		
		System.out.println(gt3.greet("Jyothsna thrice"));

		Addable ad1 = new AddableImpl();
		System.out.println(ad1.add(5,3));
		
		
		Addable ad2 = new Addable() {

			@Override
			public int add(int a, int b) {
				return a + b;
			}
			
		};
		
		System.out.println(ad2.add(5,10));
		
		Addable ad3 = (x,y) -> x+y;
		System.out.println(ad3.add(15,3));
		System.out.println("------------------------------------");
		LambdaDemo lb = new LambdaDemo();
//		lb.useLambdaInForLoop();
//		System.out.println("------------------------------------");
//		lb.useLambdaInThreading();
//		
//		System.out.println("------------------------------------");
//		lb.useLambdaInCollection();
//		System.out.println("------------------------------------");
//		lb.doBehaviourPassing();
		lb.doBinaryOperations();
	
	}//end of main

}//end of class
