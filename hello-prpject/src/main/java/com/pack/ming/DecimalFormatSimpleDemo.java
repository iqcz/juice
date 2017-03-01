package com.pack.ming;

import java.text.DecimalFormat;

/**
 * 数字格式化
 * @author TurtusLi
 *
 */
public class DecimalFormatSimpleDemo {

    public static void main(String[] args) {
	simpleFormat("###,###.###", 123456.789);
	simpleFormat("00000000.###kg", 123456.789);
	simpleFormat("000000.000", 123.78);

	useApplePatternMethodForm("#.###%", 0.78);
	useApplePatternMethodForm("###.##", 123456.781); // 最后一位四舍五入，保留两位小数
	useApplePatternMethodForm("0.00\u2030", 0.789); // 千分位格式
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
