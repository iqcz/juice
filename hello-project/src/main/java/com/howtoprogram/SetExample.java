package com.howtoprogram;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 可以使用Set来处理具有重复元素的List。
 * @author i324779
 *
 */
public class SetExample {

    public static void main(String[] args) {
        // create and display a List<String>
        String[] colors = { "red", "white", "blue", "green", "gray", "orange", "tan", "white",
                "cyan", "peach", "gray", "orange" };

        List<String> list = Arrays.asList(colors);
        System.out.printf("List: %s%n", list);

        // eliminate duplicates then print the unique values
        printNonDuplicates(list);
    }

    // create a Set from a Collection to eliminate duplicates
    private static void printNonDuplicates(Collection<String> values) {
        Set<String> set = new HashSet<>(values);

        System.out.printf("%nNonduplicates are: ");

        for (String value : set) {
            System.out.printf("%s ", value);
        }

        System.out.println();
    }
} // end class SetTest