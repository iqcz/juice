package com.pack.ming;

import java.text.DecimalFormat;

public class DecimalFormatSimpleDemo {

    public static void main(String[] args) {
	simpleFormat("###,###.###", 123456.789);
	simpleFormat("00000000.###kg", 123456.789);
	simpleFormat("000000.000", 123.78);

	useApplePatternMethodForm("#.###%", 0.789);
	useApplePatternMethodForm("###.##", 123456.78);
	useApplePatternMethodForm("0.00\u2030", 0.789);
    }

    public static void simpleFormat(String pattern, double value) {
	DecimalFormat myFormat = new DecimalFormat(pattern);
	String output = myFormat.format(value);
	System.out.println(value + "|" + pattern + "|" + output);
    }

    public static void useApplePatternMethodForm(String pattern, double value) {
	DecimalFormat myFormat = new DecimalFormat(pattern);
	myFormat.applyPattern(pattern);
	System.out.println(value + "|" + pattern + "|" + myFormat.format(value));
    }
}
