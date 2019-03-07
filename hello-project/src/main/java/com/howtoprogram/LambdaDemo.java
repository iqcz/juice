package com.howtoprogram;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 操作过程
 * Collection -> Stream -> Stream -> Stream -> Collection
 * 
 * @author i324779
 *
 */
public class LambdaDemo {

    public static void main(String[] args) {
	String[] input = { "tiger", "cat", "TIGER", "Tiger", "leopard" };
	List<String> cats = Arrays.asList(input);
	String search = "tiger";

	String tigers = cats.stream().filter(s -> s.equalsIgnoreCase(search)).collect(Collectors.joining(", "));

	System.out.println(tigers);

	Predicate<String> p = s -> s.equalsIgnoreCase(search);
	Predicate<String> combined = p.or(s -> s.equals("leopard"));

	String pride = cats.stream().filter(combined).collect(Collectors.joining(", "));
	System.out.println(pride);

	List<Integer> nameLength = cats.stream().map(String::length).collect(Collectors.toList());
	System.out.println(nameLength);

	List<String> pets = Arrays.asList("dog", "cat", "fish", "iguana", "ferret");
	pets.stream().forEach((s) -> System.out.println("*--" + s + "--*"));

	// stream of method usage
	double sumPrimes = ((double) Stream.of(2, 3, 5, 7, 11, 13, 17, 19, 23).reduce(0, (x, y) -> {
	    return x + y;
	}));
	System.out.println("Sum of some primes: " + sumPrimes);

    }

}
