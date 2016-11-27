package com.packt.mvneclipse.enumdemo;

public class ColorDemo {

	public static void main(String[] args) {
//		System.out.println(Color.BLACK);
		Color[] colors = Color.values();
		for(Color c : colors) {
			System.out.println("Name: " + c.name());
			System.out.println("codinal: " + c.ordinal());
			System.out.println("tostring: " + c.toString());
		}
		
	}

}
