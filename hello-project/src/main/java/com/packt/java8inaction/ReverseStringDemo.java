package com.packt.java8inaction;

public class ReverseStringDemo {

    public static void main(String[] args) {
	String s = "Hello world!";
	System.out.println("Original string is :" + s);

	System.out.println("After reverse string.");
	StringBuffer sb = new StringBuffer(s);
	System.out.println(sb.reverse().toString());
    }

}
