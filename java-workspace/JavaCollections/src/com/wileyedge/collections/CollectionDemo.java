package com.wileyedge.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;


class  Student implements Comparable<Student>{
	private int roll_no;
	private String name;
	
	
	public Student(int roll_no, String name) {
		this.roll_no = roll_no;
		this.name = name;
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [roll_no=" + roll_no + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		System.out.println("Inside hashcode");
	//	return 42;
		return this.roll_no;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("Inside equals");
		if(obj instanceof Student) {
			Student s=(Student) obj;
			if(this.roll_no==s.roll_no && this.name.equals(s.name))
				return true;
		}
		return false;
	}
	@Override
	public int compareTo(Student s) {
		if(this.roll_no<s.roll_no) {
			return -1;
		}
		else if(this.roll_no==s.roll_no) {
		return 0;
		}
		else {
			return 1;
		}
	}
	public Student() {
		super();
	}
	
}
class ScienceStudent extends Student{
	public ScienceStudent(){
		
	}
}
class EngineeringStudent extends ScienceStudent{
	public EngineeringStudent(){
		
	}
}
class StudentNameComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		
		return s1.getName().compareTo(s2.getName());
	}
	
}
class StudentIdComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		
		if(s1.getRoll_no()<s2.getRoll_no()) {
			return -1;
		}
		else if(s1.getRoll_no()==s2.getRoll_no()) {
			return 0;
		}
		else
			return 1;
	}
	
}
public class CollectionDemo {
	public void testMaps() {
//		Map<Integer,String> map = new HashMap<>();
//		Map<Integer,String> map = new TreeMap<>();
//		Map<Integer,String> map = new Hashtable<>();
//		Map<Integer,Student> map = new TreeMap<>();
//		
//		Student s1 = new Student(10,"Adam");
//		Student s2 = new Student(5,"Robin");
//		Student s3 = new Student(15,"Garry");
//		Student s4 = new Student(10,"Adam");
//		
//		map.put(10, s1);
//		map.put(5, s2);
//		map.put(15, s3);
//		map.put(20, s4);
		
		//sorting and duplicates checking is done based on key
		
		
		
//		Map<Student,Integer> map = new TreeMap<>();
//		
//		Student s1 = new Student(10,"Adam");
//		Student s2 = new Student(5,"Robin");
//		Student s3 = new Student(15,"Garry");
//		Student s4 = new Student(10,"Adam");
//		
//		map.put(s1,10);
//		map.put(s2,5);
//		map.put(s3,15);
//		map.put(s4,20);
		
		//above one is using comparable
		
		//below using comparator
		Comparator<Student> comp = new StudentNameComparator();
		
		Map<Student,Integer> map = new TreeMap<>(comp);
		
		Student s1 = new Student(10,"Adam");
		Student s2 = new Student(5,"Robin");
		Student s3 = new Student(15,"Garry");
		Student s4 = new Student(10,"Adam");
		
		map.put(s1,10);
		map.put(s2,5);
		map.put(s3,15);
		map.put(s4,20);
		
		
		Set<Student> set = map.keySet();
		
		Iterator<Student> it = set.iterator();
		while(it.hasNext()) {
			Student key = it.next();
			Integer val = map.get(key);
			System.out.println(key+" "+val);
//			System.out.println(map.get(it.next()));
		}
		
		
	}
	public void testList() {
//		List list=new ArrayList();//ordered, unsorted,stores heterogenuous datatypes & allows duplicates 
//		List list=new LinkedList();//LinkedList , ArrayList & vector
									// implements List interface
									//so both have same methods(Standardization & flexibility) 
//		List list=new Vector();
//		list.add(5);
//		list.add(5);
//		list.add(3);
//		list.add(7);
//		list.add("abc");
//		list.add("pqr");
		
		
		List<String> list = new ArrayList<>();

		list.add("abc");
		list.add("pqr");
		System.out.println("======"+"Using for"+"=====");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("======"+"Using iterator"+"=====");
		Iterator iter=list.iterator();
		while(iter.hasNext()) {
			Object obj=iter.next();
			System.out.println(obj);
		}
	}
	
	public void testSets() {
//		Set set=new HashSet();//unique elements,unordered ,not sorted
//		set.add(50);
//		set.add(5);
//		set.add(3000);
//		set.add(7);
//		set.add("abc");
//		set.add("pqr");
//		set.add(111);
//		set.add(55);
		
		Comparator<Student> comp = new StudentNameComparator();
		Set<? super Student> set = new TreeSet<>(comp);
		set.add(new ScienceStudent());
		set.add(new EngineeringStudent());
		Student s1=new Student(10,"Adam");
		Student s2=new Student(5,"Robin");
		Student s3=new Student(15,"Garry");
		Student s4=new Student(15,"Garry");
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);   //internally s4 has got new address even if 
						//its set it will create new element even if the roll no and name
		
		set.add(s3);
		set.add(s4);
		System.out.println("======"+"Using iterator"+"=====");
		
		Iterator iter=set.iterator();
		while(iter.hasNext()) {
			Object obj=iter.next();
			System.out.println(obj);
		}
	}
	
	
	public void testTreeSet() {
//		StudentNameComparator com = new StudentNameComparator();
		Comparator<Student> com = new StudentNameComparator();
		StudentIdComparator com1 = new StudentIdComparator();
//		Set set = new TreeSet(com1);
		Set<Student> set = new TreeSet<>(com1);
//		Set set=new TreeSet(new StudentComparator());//unique elements, sorted
		
		Student s1=new Student(10,"Adam");
		Student s2=new Student(5,"Robin");
		Student s3=new Student(15,"Garry");
		Student s4=new Student(15,"Garry");
		
		set.add(s1);
		s1.setName("Robin");
		s1.setRoll_no(5);
		set.add(s2);
		set.add(s3);
		set.add(s4);
//		set.add("abc");gives runtime exception 
		              //its saying make sure that the elements are comparable
		
		Iterator iter=set.iterator();
		while(iter.hasNext()) {
			Object obj=iter.next();
			System.out.println(obj);
		}
	}
	public static void main(String[] args) {
		CollectionDemo demo=new CollectionDemo();
//		demo.testList();
//		demo.testSets();
//		demo.testTreeSet();
		demo.testMaps();
	}

}