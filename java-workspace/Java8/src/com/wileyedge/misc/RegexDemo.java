package com.wileyedge.misc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
	
	public void filterPassword(String str) {
		
		if(str.length()<5 || !Pattern.matches("\\d+",str) || !Pattern.matches("[a-zA-Z]+",str)) {
			System.out.println("Invalid");
		}
		else System.out.println("Valid");
	}

	public static void main(String[] args) {
		//first way
		//third character i
		Pattern p = Pattern.compile("..i.");
		Matcher m = p.matcher("amit");
		boolean b = m.matches();
		System.out.println(b);
		
		//second way
		System.out.println(Pattern.compile(".s").matcher("as").matches());
		
		//third way
		System.out.println(Pattern.matches(".s", "as"));
		
		//anything specified in square brackets should be the string
		System.out.println(Pattern.matches("[amt]", "t"));
		
		//* means 0 or more occurrences of any or all of letters
		//in the brackets
		System.out.println(Pattern.matches("[amt]*", "tmmaaattt"));
		
		//any number of digits
		//+ is one or more occurrences
		System.out.println(Pattern.matches("\\d*", "123"));
		
		//alpha numeric and length 6
		System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "amit41"));
		
		//? 0 or more
		System.out.println(Pattern.matches("[amt]?", "tt"));
		
//		^(?=.*[a-zA-Z$%^&*@])(?=.*[0-9$%^&*@]).{5,}$
		
//		check ! ("\\[A-Za-z]+") and check !("\\d+") and >6
		
		RegexDemo demo = new RegexDemo();
		demo.filterPassword("12dharani");
		
	}

}
