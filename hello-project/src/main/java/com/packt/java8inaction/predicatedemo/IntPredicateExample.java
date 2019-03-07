package com.packt.java8inaction.predicatedemo;

import java.util.function.IntPredicate;

public class IntPredicateExample {

    public static void main(String ... args) {
	IntPredicate evenNumber = i -> i % 2 == 0;
	
	System.out.println(evenNumber.test(8));
    }
}
