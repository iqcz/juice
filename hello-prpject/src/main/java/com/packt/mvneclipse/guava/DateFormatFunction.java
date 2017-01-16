package com.packt.mvneclipse.guava;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.common.base.Function;

public class DateFormatFunction implements Function<Date, String> {
	
	private String dateFormat;
	
	public DateFormatFunction(String dateFormat) {
		this.setDateFormat(dateFormat);
	}

	@Override
	public String apply(Date input) {
		return new SimpleDateFormat(this.getDateFormat()).format(input);
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

}
