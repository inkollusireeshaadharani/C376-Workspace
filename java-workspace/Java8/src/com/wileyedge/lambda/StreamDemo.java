package com.wileyedge.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Status{
	OPEN, CLOSED
}

class Student1{
	private String name;
	private Set<String> certifications;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getCertifications() {
		return certifications;
	}

	public void setCertifications(Set<String> certifications) {
		this.certifications = certifications;
	}

	public void addCertification(String certi) {
        if (this.certifications == null) {
          this.certifications = new HashSet<>();
        }
        this.certifications.add(certi);
	}

	@Override
	public String toString() {
		return "Student1 [name=" + name + ", certifications=" + certifications + "]";
	}
	
}

class Person{
	private String name;
	private String gender;
	private int age;
	public Person(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
}

class Task{
	private int points;
	private Status status;
	
	public Task(int points, Status status) {
		this.points = points;
		this.status = status;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}

public class StreamDemo {

	public static void main(String[] args) {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(8,Status.OPEN));
		tasks.add(new Task(5,Status.OPEN));
		tasks.add(new Task(10,Status.CLOSED));
		
		//calculate sum of only open tasks
		
		Stream<Task> stream = tasks.stream().filter((t)-> t.getStatus()==Status.OPEN);
		stream.mapToInt((t) -> t.getPoints());
		
		int sum = tasks.stream().filter((t)-> t.getStatus()==Status.OPEN).mapToInt((t) -> t.getPoints()).sum();
		System.out.println(sum);
		
		
		/*Firstly, the tasks collection is converted to its stream representation.
	    *Then, the filter operation on stream filters out all CLOSED tasks. 
		*On next step, the mapToInt operation converts the stream of Tasks
		*to the stream of Integers using Task::getPoints method of the each task instance. 
		*And lastly, all points are summed up using sum method, producing the final result.
		*/
		
		//stream operations -- terminal, intermediate
		//original list remains untouched
		
		//chain of intermediate operations -- pipeline
		
		/*
		* Stream operations are divided into intermediate and terminal operations.
		* Intermediate operations return a new stream. e.g. Filter
		* filter does not actually perform any filtering, but instead creates a new stream that, when traversed, 
		* contains the elements of the initial stream that match the given predicate.
		* Intermediate operations are always Lazy.
		*/
		
		/*
		 * Terminal operations may traverse the stream to produce a result or a side-effect. e.g. forEach or sum
		 * After the terminal operation is performed, the stream pipeline is considered consumed, and can no longer be used.
		 * Terminal operations are eager.
		 */
		
		 Set<Integer> set = new HashSet<>(); 
		 List<Integer> list = new ArrayList<>();
		 list.add(5);
		 list.add(2);
		 list.add(9);
		 list.add(7);
		 
		 System.out.println("forEach with lambda");
		 list.forEach((item)-> System.out.println(item));
		 System.out.println("forEach with method inference");
		 list.forEach(System.out :: println );
		 System.out.println("forEach on stream & method inference");
		 list.stream().forEach(System.out :: println);
		 System.out.println("forEach on stream parallel");
		 list.stream().parallel().forEach(System.out :: println);
		 System.out.println("forEach on stream parallel & maintaining order");
		 list.stream().parallel().forEachOrdered(System.out :: println);
		 
//		 parallel() : the stream is split into multiple chunks, with each chunk processed independently 
//		 and with the result summarized at the end.
		 
		 Set<Object> set1 = new HashSet<>(); 
		 set1.add(5); 
		 set1.add("amit");
		 set1.add("3");
		 
		 set1.stream().mapToInt((t)->{
			 if(t instanceof String) {
				 try {
					 return Integer.parseInt(t.toString());
				 }
				 catch(NumberFormatException nfe) {
					 return 0;
				 }
			 }
			 else if(t instanceof Integer) {
				 return ((Integer)t).intValue();
			 }
			 return 0;
		 }).forEach(System.out::println);
		 //set doesn't maintain order
		 
		 //print squares of those
		 list.stream().mapToInt((x)->x*x).forEach(System.out :: println);
		 
		 list.stream().mapToInt((x)->x*2).average();
		 
		 OptionalDouble od = list.stream().mapToInt((x)->x*2).average();
		 if(od.isPresent()) {
			 System.out.println("average of double of numbers is "+od.getAsDouble());
		 }
		 
		 list.stream().mapToInt((x)->x*2).findAny();
		//Returns an OptionalInt describing some element of the stream, 
		 //or an empty OptionalInt if the stream is empty.
		 OptionalInt oi = list.stream().mapToInt((x)->x*2).findAny();
		 if(oi.isPresent()) {
			 System.out.println("any number is "+oi.getAsInt());
		 }
		 OptionalInt oi2 = list.stream().mapToInt((x)->x*2).findFirst();
		 if(oi2.isPresent()) {
			 System.out.println("first number is "+oi2.getAsInt());
		 }
		 
		 
		 System.out.println("max square is "+list.stream().mapToInt((x)->x*2).max().getAsInt());
		 System.out.println("sum of squares is "+list.stream().mapToInt((x)->x*2).sum());
		 
		 boolean isAnyMatch = list.stream().mapToInt((x)->x*2).anyMatch(new IntPredicate() {
			@Override
			//just like predicate but int predicate
			//because we used maptoInt and new stream has int values
			public boolean test(int value) {
				if(value==10) {
					return true;
				}
				else {
					return false;
				}
			}
		 });
		 System.out.println(isAnyMatch);
		 boolean isAllMatch = list.stream().mapToInt((s) -> (int)s*2).allMatch((n)-> n>3 );
		 System.out.println(isAllMatch);
		 //all of the numbers must be greater than 3
		 
		//The Collectors class has a few imp methods like averagingInt and groupingBy
		 List<Integer> intlist = Arrays.asList(5,9,7,2);
		 //map takes Function object
		 //map -> one format to another
		 
		 //check documentation
		 Double db = intlist.stream().map(new Function<Integer,Integer>() {

			@Override
			public Integer apply(Integer value) {
				// TODO Auto-generated method stub
				return 0;
			}
					 
		 }).collect(Collectors.averagingInt((x) -> x*2));
		 Double db1 = intlist.stream().map((x)->x*2).collect(Collectors.averagingInt((x)->x*2));
		 List<Person> persons = Arrays.asList(new Person("Amit","Male",38), 
				 new Person("Prachi","Female",34),
				 new Person("Banesh","Male",22));
		 
		 System.out.println("average of male "+persons.stream().filter((t)->t.getGender().equals("Male"))
		 .mapToInt((t)-> t.getAge()).average().getAsDouble());
		 
		 //Function<Input type,Output type>
//		 persons.stream().collect(Collectors.groupingBy(new Function<Person,String>(){
//			@Override
//			public String apply(Person t) {
//				return t.getGender();
//			}			 
//		 }));
		 
//		 Collectors has static method: groupingBy
		 Map<String, List<Person>> namesPerGender = persons.stream().collect(Collectors.groupingBy(new Function<Person,String>(){
				@Override
				public String apply(Person t) {
					return t.getGender();
				}			 
			 }));
		 System.out.println(namesPerGender);
		 
		 System.out.println(persons.stream().collect(Collectors.groupingBy(p->p.getGender())));
//		 persons.removeIf((Person p)-> p.getName().equalsIgnoreCase("Amit") );
//		 System.out.println(persons);
//		 can't remove in above example since remove operation isn't supported
		 
		 namesPerGender.computeIfPresent("Male", (gender, personlist) -> {
      	   personlist.removeIf((Person p) ->  { return (p.getName().equalsIgnoreCase("Banesh"));});
    		   return personlist;	   
            });
		 namesPerGender.forEach((gender, personList)-> System.out.println(gender+"-->"+personList));	
//		 System.out.println(namesPerGender);
		 
		 //flatmap method
		//flatmap works in case of nested fors - 
		 //2D to 1D
//		 { {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}
		 
		 Student1 s1 = new Student1();
         s1.setName("Amit"); 
         s1.addCertification("SCJP");
         s1.addCertification("SCWCD");
         s1.addCertification("OCJP");
         
         Student1 s2 = new Student1();
         s2.setName("Sujay"); 
         s2.addCertification("BCD");
         s2.addCertification("Oracle");
         
         List<Student1> studlist = new ArrayList<>();
         studlist.add(s1);
         studlist.add(s2);
         
         studlist.stream().map((x)->x.getCertifications());
         ///returns stream of set of strings
       //we want stream of strings
         studlist.stream().map((x)->x.getCertifications()).flatMap((x)->x.stream()).distinct().collect(Collectors.toList()).forEach(System.out::println);
         
         System.out.println(Status.CLOSED);
         
         
	}
	

}























