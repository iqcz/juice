package com.packt.java8inaction.functiondemo;

import java.util.Arrays;
import java.util.List;

public class FunctionExample {

    public static void main(String[] args) {
	List<Integer> length = FunctionTransform.transfer(Arrays.asList("jiayou", "buzuo", "ningsi"), s -> s.length());
	
	System.out.println(length);
    }

}
