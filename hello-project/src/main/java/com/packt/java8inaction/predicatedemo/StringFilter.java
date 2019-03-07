package com.packt.java8inaction.predicatedemo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 使用 Predicate 函数式接口对字符串进行过滤
 * @author TurtusLi
 *
 * @param <T>
 */
public class StringFilter<T> {
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
	List<T> results = new ArrayList<>();
	for (T t : list) {
	    if(p.test(t)) {
		results.add(t);
	    }
	}
	
	return results;
    }
}
