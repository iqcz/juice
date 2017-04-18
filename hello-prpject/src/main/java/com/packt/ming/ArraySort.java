package com.packt.ming;

import java.util.Arrays;

public class ArraySort {

    public static void main(String[] args) {
	Integer[] numbers = { 2, 9, 90, 1, 92 };
//	Arrays.parallelSort(numbers, (first, second) -> first.compareTo(second));
//	Arrays.parallelSort(numbers, (first, second) -> {return first.compareTo(second);});
	
	for(Integer n : numbers) {
	    System.out.printf("%d, ", n);
	}
	
	Runnable run1 = () -> System.out.println("Thread is running.");
    }

}
