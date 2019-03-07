package com.packt.mvneclipse.java8time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 使用java8中的java.time包下的类对时间进行操作
 * @author TurtusLi
 *
 */
public class GetDatetime {

	public static void main(String[] args) {
		LocalDateTime nowDate = LocalDateTime.now();
		System.out.println(nowDate);
		
		LocalDate date = LocalDate.now();
		System.out.println(date);
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
	}

}
