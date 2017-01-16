package com.packt.mvneclipse.guava;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class FunctionExample implements Function<Date, String> {

	private static final String format = "dd/mm/yyyy";

	public static void main(String[] args) {
		FunctionExample example = new FunctionExample();
		String today = example.apply(new Date());
		System.out.println(today);

		Function<Date, String> myFunc = new Function<Date, String>() {
			@Override
			public String apply(Date input) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				return dateFormat.format(input);
			}
		};
		System.out.println(myFunc.apply(new Date()));

		System.out.println("----");
		
		DateFormatFunction function = new DateFormatFunction(format);
		Date date = new Date();
		List<Date> dates = Lists.newArrayList();
		dates.add(date);
		dates.add(date);
		
		// formattedDates: list内的元素类型转换：date-> string.
		List<String> formattedDates = Lists.transform(dates, function);
		System.out.println(formattedDates);
		
	}

	@Override
	public String apply(Date input) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(input);
	}

}
