package com.packt.java8inaction;

public interface Comparators {

    public static Integer ascending(Integer first, Integer second) {
	return first.compareTo(second);
    }
}
