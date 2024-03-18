package com.str.utility;

public class StringDemo {
		
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = new String("Hello");
		
		if(s1==s2) {
			System.out.println("Both are pointing to same memory location");
		}
		else{
			System.out.println("Both are not pointing to same memory location");
		}
		
		if(s1.equals(s2)) {
			System.out.println("Both are equal");
		}
		else{
			System.out.println("Both are not equal");
		}
		
		String s3 = s1.concat("World");
		System.out.println(s3);
		
		System.out.println(s3.substring(2,5));
		System.out.println(s3.indexOf('l'));
		System.out.println(s3.lastIndexOf('l'));
		System.out.println(s3.indexOf("ll"));
		s3=s3.replace("l", "p");
		System.out.println(s3);
		
		String[] strarr=s3.split("pp");
		for(String s : strarr) {
			System.out.println(s+" ");
		}
		
		System.out.println(s3.startsWith("Hell"));
		System.out.println(s3.toLowerCase());
		System.out.println(s3.toUpperCase());
		
	}

}
