package com.wileyedge.misc;

enum Gender{
	MALE, FEMALE
}

enum MathOperator{
	PLUS, MINUS, MULTIPLY, DIVIDE
}

enum Days{
	MONDAY(100), TUESDAY(101), WEDNESDAY(102), THURSDAY(103),
	FRIDAY(104), SATURDAY(105), SUNDAY(106);
	int n;
	Days(int x){
		n = x;
	}
	
	public int getValue() {
		return n;
	}
}

public class EnumDemo {

	public static int calculate(MathOperator op,int num1,int num2) {
		switch(op) {
		case PLUS:
			return num1 + num2;
		case MINUS:
			return num1 - num2;
		case MULTIPLY:
			return num1 * num2;
		case DIVIDE:
			return num1 / num2;
		default:
			throw new UnsupportedOperationException();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(calculate(MathOperator.PLUS,5,3));
		System.out.println(calculate(MathOperator.MINUS,5,3));
		System.out.println(calculate(MathOperator.MULTIPLY,5,3));
		System.out.println(calculate(MathOperator.DIVIDE,5,3));
		
		Days aday = Days.FRIDAY;
		
		switch(aday) {
		case MONDAY: System.out.println("OHHH IT'S A MONDAY"); break;
		case FRIDAY: System.out.println("YAYY IT'S A FRIDAY...WEEKEND"); break;
		case SUNDAY: System.out.println("WOOHOO IT'S A SUNDAY...HOLIDAY"); break;
		}
		
		Days d = Days.MONDAY;
		
		switch(d.getValue()) {
		case 100: System.out.println("OHHH IT'S A MONDAY"); break;
		case 104: System.out.println("YAYY IT'S A FRIDAY...WEEKEND"); break;
		case 106: System.out.println("WOOHOO IT'S A SUNDAY...HOLIDAY"); break;
		}
		
		//enums to define set of predefined related constants
		
	}

}
