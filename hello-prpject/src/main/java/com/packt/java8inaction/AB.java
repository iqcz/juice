package com.packt.java8inaction;

public class AB {

    public static void main(String[] args) {
	A a = () -> System.out.println("A"); 
	B b = () -> System.out.println("B"); 
	a.apply();
	b.apply();
    }

}
