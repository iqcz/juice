package com.packt.java8inaction;

import java.util.Arrays;
import java.util.Collections;

public class StaticMethodReference {

    public static void main(String[] args) {

	Collections.sort(Arrays.asList(5, 12, 4), Comparators::ascending);

	// equivalent to
	Collections.sort(Arrays.asList(5, 12, 4), (a, b) -> Comparators.ascending(a, b));
    }

}
