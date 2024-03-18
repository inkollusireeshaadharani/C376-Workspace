package com.datastructures;

import com.datastructures.impl.MyLinkedList;

public class LLTest {

	public static void main(String[] args) {
		MyLinkedList<Integer> mll = new MyLinkedList<>();
//		mll.addFirst(10);
//		mll.add(20);
//		mll.add(30);
//		mll.add(40);
//		mll.add(50);
//		mll.addLast(90);
//
//		mll.insert(5, 35);
//		System.out.println(mll);
//		System.out.println(mll.get(5));
//		System.out.println(mll.deleteFirst());
//		System.out.println(mll);
//		System.out.println(mll.deleteLast());
//		System.out.println(mll);
//		System.out.println(mll.delete(4));
//		System.out.println(mll);
		mll.add(7);
		mll.add(5);
		mll.add(9);
		mll.add(2);
		mll.delete(2);
		mll.insert(3,10);
		System.out.println(mll);
	}

}
