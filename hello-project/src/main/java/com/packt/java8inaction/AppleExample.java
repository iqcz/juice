package com.packt.java8inaction;

import java.util.Comparator;

public class AppleExample {
    // before Java 8
    Comparator<Apple> bfCom = new Comparator<Apple>() {
	@Override
	public int compare(Apple o1, Apple o2) {
	    return o1.getWeight().compareTo(o2.getWeight());
	}
    };
    
    // Java 8 Lambda expression
    Comparator<Apple> crCom = (o1, o2) -> o1.getWeight().compareTo(o2.getWeight());

}
