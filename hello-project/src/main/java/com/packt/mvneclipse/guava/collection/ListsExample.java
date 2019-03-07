package com.packt.mvneclipse.guava.collection;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class ListsExample {

	public static void main(String[] args) {

		ArrayList<String> names = Lists.newArrayList("xiaoming", "xiaoqiang", "xiaohong", "xiaoli");
		
		List<String> reverseNames = Lists.reverse(names);
		
		System.out.println(names);
		System.out.println(reverseNames);
		
		List<List<String>> partList = Lists.partition(names, 3);
		
		System.out.println(partList);
		
	}

}
