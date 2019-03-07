package com.packt.mvneclipse.java8time;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

public class LeapYear {

	public static void main(String[] args) {
		Year year1 = Year.of(2012);
		YearMonth yearMonth = year1.atMonth(2);
		LocalDate localDate2 = yearMonth.atDay(29);
		System.out.println(localDate2);
		
		System.out.println("Leap Year: " + localDate2.isLeapYear());
		
		MonthDay monthDay = MonthDay.of(2, 29);
		LocalDate localDate = monthDay.atYear(2014); // 如果不是閏年，自動轉化
		System.out.println(localDate);
	}

}
