package com.packt.mvneclipse.collectiondemo;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		SortedSet<String> ts = new TreeSet<>();
		
		// 不推荐下面创建TreeSet对象的方法，
		// TreeSet实现直接上层的接口是SortedSet接口，
		// 可以直接只用它的一些方法，例如last，first方法。
		//Set<String> ts = new TreeSet<>();
		ts.add("C");
		ts.add("A");
		ts.add("B");
		ts.add("E");
		ts.add("F");
		ts.add("D");

		System.out.println(ts.first());
		System.out.println(ts.last().length());
	}

}
