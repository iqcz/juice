package com.packt.mvneclipse.java8time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 將時間對象格式化爲字符串
 * @author TurtusLi
 *
 */
public class DateFormatDemo {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		String strDate = localDate.format(dtf);
		System.out.println(strDate);
	}

}
