package com.datastructures;

import com.datastructures.exp.EmptyQueueException;
import com.datastructures.exp.QueueIsFullException;
import com.datastructures.impl.MyCircularQueue;

public class CQTest {
	public static void main(String[] args) {
		MyCircularQueue<Integer> mcq = new MyCircularQueue<>();
		//11, 33, 44, 66, 99
		mcq.setCapacity(4);
		try {
			mcq.enque(11);
			mcq.enque(33);
			mcq.enque(44);
			mcq.enque(99);
			mcq.enque(66);
			System.out.println(mcq);
			System.out.println(mcq.deque());
			mcq.enque(66);
		} catch (QueueIsFullException | EmptyQueueException  e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(mcq);

	}
}
