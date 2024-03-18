package com.datastructures;
import java.util.Queue;
import java.util.Comparator;
import java.util.PriorityQueue;

class MyComparator implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		return -(s1.compareTo(s2));
	}
	
}
public class PriorityQueue2 {

	public static void main(String[] args) {
//		Queue<String> pq=new PriorityQueue<>();
//		Natural ordering
//		pq.add("Hello");
//		pq.add("HackerRaNK");
		
//		String s1=pq.poll();
//		System.out.println(s1);
	
		Queue<String> pq=new PriorityQueue<>(new MyComparator());
		pq.add("Hello");
		pq.add("HackerRaNK");
		String s1=pq.poll();//removes and adds
		System.out.println(s1);
		
		/*
		The remove() and poll() methods differ only in their behavior		
		when the queue is empty: 
		the remove() method throws an exception, 
		while the poll() method returns null.
		
		The element() and peek() methods return, but do not remove, 
		the head of the queue.
				
		
		add() will throw an IllegalStateException if no space is currently available 
		in the Queue, otherwise add method will return true. offer() method will 
		return false if the element cannot be inserted due to capacity restrictions
				
			*/	
		pq.remove();
		
		
		System.out.println(s1);
		
		String s2=pq.remove();
		System.out.println(s2);
	}

}