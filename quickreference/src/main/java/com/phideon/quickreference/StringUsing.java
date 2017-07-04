package com.phideon.quickreference;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Locale;

public class StringUsing {

    public static void main(String[] args) throws UnsupportedEncodingException {
	// 1, charAt()
	String strCom1 = "I like Java.";
	System.out.println(strCom1.charAt(4));

	String strCom2 = "我喜欢Java";
	System.out.println(strCom2.charAt(2));

	// 2, compareTo()
	String strCom3 = "IlikeJava.";
	String strCom4 = "IlikeC.";
	System.out.println(strCom3.compareTo(strCom4));

	// 3, compareToIgnoreCase()
	String strCom5 = "java";
	String strCom6 = "JAVA";
	System.out.println(strCom5.compareToIgnoreCase(strCom6));

	// 4, contains()
	String strCom7 = "ILIKEJAVA";
	System.out.println(strCom7.contains("JAVA")); // true

	// 5，copyValueOf() 必须是char类型，把char类型数组转换为一个字符串
	char[] strArr = { '书', '山', '有', '路' };
	String str = String.copyValueOf(strArr);
	System.out.println(str);

	// 6, endWith
	// 7, equalsIgnoreCase

	// format()
	Date date = new Date();
	Locale form = Locale.CHINA;
	String year = String.format(form, "%tY", date);
	System.out.println(year);

	// getBytes
	String strCom8 = "Java";
	byte[] byteArr = strCom8.getBytes();
	for (int i = 0; i < byteArr.length; i++) {
	    System.out.print(byteArr[i] + ", ");
	}
	System.out.println();

	byte[] byteArr1 = strCom8.getBytes(Charset.defaultCharset());
	for (int i = 0; i < byteArr1.length; i++) {
	    System.out.print(byteArr1[i] + ", ");
	}
	System.out.println();

	// byte[] byteArr2 = strCom8.getBytes(Charset.forName("GBK"));
	byte[] byteArr2 = strCom8.getBytes("GBK");
	for (int i = 0; i < byteArr2.length; i++) {
	    System.out.print(byteArr2[i] + ", ");
	}
	System.out.println();
	
	// isEmpty
	String strCom9 = null;
	System.out.println(strCom9.isEmpty()); // java.lang.NullPointerException
	
	// toCharArray,字符串转换成char数组
	
	// toLowerCase
	
	// toUpperCase
	
	// trim
	
	// valueOf：基本类型转换成String。
    }

}
