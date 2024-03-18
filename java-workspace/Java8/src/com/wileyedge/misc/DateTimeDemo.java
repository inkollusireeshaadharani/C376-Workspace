package com.wileyedge.misc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;

public class DateTimeDemo {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println(today);
		LocalDateTime date2 = LocalDateTime.now();
		System.out.println(date2);
		LocalDate bday = LocalDate.of(2002, Month.AUGUST, 25);
		Period age = Period.between(bday, today);
		System.out.println("My age is: "+age.getYears()+" years "
		+age.getMonths()+" months "+age.getDays()+" days ");
		System.out.println("Date After 10 days: "+today.plusDays(10));
		System.out.println("Date Before 10 days: "+today.minusDays(10));
		System.out.println("Date After 3 weeks: "+today.plusWeeks(3));
		System.out.println("Date After 20 months: "+today.plusMonths(20));
		System.out.println("Date After 2 Years: "+today.plusYears(2));
		ZoneId aus= ZoneId.of("Australia/Sydney");
		LocalDateTime time_in_aus=LocalDateTime.now(aus);
		System.out.println("Time in america: "+time_in_aus);
		//explore more
		
	}

}
