package com.packt.java8inaction.predicatedemo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringFilterExample {

    public static void main(String[] args) {

	// name 不能未null并且不能为空
	Predicate<String> nonEmptyStringPredicate = s -> !( null == s ||s.isEmpty());
	
	List<String> names = new ArrayList<>();
	names.add("xiaoming");
	names.add("xiaoli");
	names.add(null);
	names.add("");
	names.add("xiaohua");
	
	List<String> notEmptyNames = StringFilter.filter(names, nonEmptyStringPredicate);
	System.out.println(notEmptyNames);
    }

}
