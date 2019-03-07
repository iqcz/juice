package com.packt.mvneclipse.javainanutshell.io;

public class StringDemo {

    public static void main(String[] args) {
	String str = "abcdefghijkalmn";
	
	System.out.println(str.indexOf('a'));
	System.out.println(str.indexOf('e'));
	
	System.out.println(str.substring(str.indexOf('a'), str.indexOf('e')));
	
	
    }

}
