package com.packt.ming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySort {

    public static void main(String[] args) {
        Integer[] numbers = { 2, 9, 90, 1, 92 };
        // Arrays.parallelSort(numbers, (first, second) -> first.compareTo(second));
        Arrays.parallelSort(numbers, Integer::compareTo);

        for (Integer n : numbers) {
            System.out.printf("%d, ", n);
        }

        Runnable run1 = () -> System.out.println("Thread is running.");

        // 使用代码快初始化 list 的 value
        List<String> extensions = new ArrayList<String>() {
            private static final long serialVersionUID = 2028514244500563526L;
            {
                add("action");
                add("");
            }
        };

        System.out.println(extensions);
    }
}
