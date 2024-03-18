package com.datastructures;

import com.datastructures.impl.MyCircularDoubleLinkedList;
import com.datastructures.impl.MyDoublyLinkedList;

public class DLLTest {

	public static void main(String[] args) {
		MyDoublyLinkedList<Integer> mdll = new MyCircularDoubleLinkedList<>();
		mdll.addFirst(10);
		mdll.add(20);
		mdll.add(30);
		mdll.add(40);
		mdll.add(50);
		mdll.addLast(60);
		mdll.addFirst(5);
		System.out.println(mdll);
		mdll.insert(2, 25);
		System.out.println(mdll);
		mdll.insert(0, 2);
		System.out.println(mdll);
		System.out.println("index 5: "+mdll.get(5));
		mdll.insert(9, 70);
		mdll.insert(10, 79);
		System.out.println(mdll);
		System.out.println(mdll.getFirst());
		System.out.println(mdll.getLast());
		System.out.println(mdll);
		System.out.println(mdll.reverse());
		
		System.out.println("after deleting "+mdll.deleteFirst() +" " + mdll.toString());
		
		System.out.println("after deleting "+mdll.deleteLast()+" "  + mdll.toString());
		System.out.println("after deleting "+mdll.delete(2) +" " + mdll.toString());
		System.out.println(mdll.size());
		
	}

}
