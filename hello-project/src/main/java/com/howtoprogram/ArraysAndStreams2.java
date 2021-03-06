package com.howtoprogram;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {

    public static void main(String[] args) {
        String[] strings = { "Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet" };

        // display original strings
        System.out.printf("Original strings: %s%n", Arrays.asList(strings));

        // strings in upper case
        System.out.printf("strings in uppercase: %s%n", Arrays.stream(strings)
                .map(String::toUpperCase).peek(System.out::println).collect(Collectors.toList()));

        // strings less than "n" (case insensitive) sorted ascending
        System.out.printf("strings greater than m sorted ascending: %s%n",
                Arrays.stream(strings).filter(s -> s.compareToIgnoreCase("n") < 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList()));

        // strings less than "n" (case insensitive) sorted descending
        System.out.printf("strings greater than m sorted descending: %s%n",
                Arrays.stream(strings).filter(s -> s.compareToIgnoreCase("n") < 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                        .collect(Collectors.toList()));
    }
} // end class ArraysAndStreams2
