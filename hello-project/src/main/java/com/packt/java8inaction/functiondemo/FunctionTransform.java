package com.packt.java8inaction.functiondemo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionTransform<T, R> {

    public static <T, R> List<R> transfer(List<T> list, Function<T, R> func) {
	List<R> results = new ArrayList<>();
	for(T t : list) {
	   results.add(func.apply(t));
	}
	
	return results;
    }
}
