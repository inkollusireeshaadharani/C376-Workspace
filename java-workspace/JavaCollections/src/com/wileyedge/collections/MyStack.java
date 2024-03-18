package com.wileyedge.collections;

public class MyStack<E> {
	private int x;
	private E[] data = (E[]) new Object[10];
	
	public void push(E obj) {
		data[x] = obj;
		x++;
	}
	
	public E pop() {
		x--;
		return data[x];
	}
	
	public static void main(String[] args) {
//		MyStack ms = new MyStack();
		MyStack<String> ms = new MyStack<>();
		ms.push("Hello");
		ms.push("Bello");
		ms.push("Cello");
		System.out.println(ms.pop());
		System.out.println(ms.pop());
		
		MyStack<Integer> ms2 = new MyStack<>();
		ms2.push(10);
		ms2.push(20);
		ms2.push(30);
		System.out.println(ms2.pop());
		System.out.println(ms2.pop());
	}

}
