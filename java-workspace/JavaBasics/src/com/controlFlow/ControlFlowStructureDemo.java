package com.controlFlow;

public class ControlFlowStructureDemo {

	public static void main(String[] args) {
		int a = 2;
		if(a == 1) {
			System.out.println("Good morning");
		}
		else if(a == 2) {
			System.out.println("Good afternoon");
		}
		else {
			System.out.println("Good evening");
		}
		
		//conditional branching
		switch(a) {
			case 1:{
				System.out.println("Good morning");
				break;
			}
			case 2:{
				System.out.println("Good afternoon");
				break;
			}
			case 3:{
				System.out.println("Good evening");
				break;
			}
			default:{
				System.out.println("Good night");
			}

		}
		
		int var = 0;
		while(var>5) {
			System.out.println(var);
			var++;
		}
		
		var=0;
		do {
			System.out.println(var);
			var++;
		}while(var>5);
		
		for(int i = 0; i<5;i++) {
			for(int j = 0; j < 5; j++) {
				//i and not j
				if(i==2) continue;
				System.out.println(i);
			}
		}
		
		int[] arr = new int[4];
		arr[0]=10;
		arr[1]=20;
		arr[2]=30;
		arr[3]=40;
		
		int[] arr1 = new int[] {10,20,30,40};
		for(int i = 0; i<4;i++) {
			System.out.println(arr[i]);
		}
		for(int num : arr1) {
			System.out.println(num);
		}
	}

}
