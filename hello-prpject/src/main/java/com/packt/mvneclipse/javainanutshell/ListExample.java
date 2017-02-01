package com.packt.mvneclipse.javainanutshell;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.transform.stream.StreamSource;

public class ListExample {

	public static void main(String[] args) {

		CopyOnWriteArrayList<String> cow = new CopyOnWriteArrayList<>();

		String[] input = { "tiger", "cat", "TIGER ", "Tiger", "leopard" };
		List<String> cats = Arrays.asList(input);
		
		// search condition
		String search = "tiger";

		String joinedInput = cats.stream().filter(s -> s.equalsIgnoreCase(search)).collect(Collectors.joining("|"));
		long count = cats.stream().count();
		System.out.println(joinedInput);
		
		System.out.printf("count: %d.\n", count);
		
		List<Integer> namesLength = cats.stream().map(String::length).collect(Collectors.toList());
		
		System.out.println(namesLength);
		
		List<String> namesChar = cats.stream().map(String::trim).collect(Collectors.toList());
		
		System.out.println(namesChar);	
		
		System.out.println("============");
		
		cats.stream().forEach(System.out::println);
		
		double sumPrims = Stream.of(2, 3, 5, 7, 11, 13, 17, 19, 23).reduce(0, (x, y) -> x + y).doubleValue();
		System.out.printf("Sum: %.2f.", sumPrims);
	}

}
