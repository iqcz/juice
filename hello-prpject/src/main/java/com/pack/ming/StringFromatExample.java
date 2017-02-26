package com.pack.ming;

import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.Locale;
import static java.util.Calendar.*;

public class StringFromatExample {

    public static void main(String[] args) {

	Date date = new Date();
	String s = String.format("%te", date); // 一个月的某一天
	String d = String.format("%td", date);
	String m = String.format("%tm", date);
	String y = String.format("%tY", date);
	System.out.printf("%s, %s, %s, %s\n", s, d, m, y);
	// 日期转换的新写法，具体语法请参考Formatter类
	System.out.println(String.format("%1$tY/%1$tm/%1$td", date));

	System.out.println("+++++++++++++++++++++++");

	System.out.println(String.format("%tF", date));

	Calendar c = Calendar.getInstance();
	String s1 = String.format("Duke's Birthday: %1$tm %1$te,%1$tY", c);
	String s2 = String.format("Duke's Birthday: %1$tm %<te,%<tY", c);

	System.out.println(s1);
	System.out.println(s2);

	System.out.println("+++++++++++++++++++++++");

	StringBuilder sb = new StringBuilder();
	// Send all output to the Appendable object sb
	Formatter formatter = new Formatter(sb, Locale.US);

	// Explicit argument indices may be used to re-order output.
	System.out.println(formatter.format("%4$3s|%3$3s|%2$3s|%1$3s", "a", "b", "c", "d"));
	// -> " d c b a"

	Calendar c1 = new GregorianCalendar(1995, MAY, 23);
	String ss = String.format("Duke's Birthday: %1$tb %1$te, %1$tY", c1);
	// -> ss == "Duke's Birthday: May 23, 1995"
	
	System.out.println(ss);
    }

}
