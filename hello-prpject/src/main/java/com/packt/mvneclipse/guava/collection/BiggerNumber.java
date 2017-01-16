package com.packt.mvneclipse.guava.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;

public class BiggerNumber implements Comparator<Double> {

	@Override
	public int compare(Double o1, Double o2) {
		return Doubles.compare(o1, o2);
	}

	public static void main(String...args) {
		BiggerNumber bn = new BiggerNumber();
		System.out.println(bn.compare(9.2, 9.2));
		
		
		ArrayList<String> names = Lists.newArrayList("hello", "world", "Lingling");
		System.out.println(names);
		
		Iterable<String> namesBySearch = FluentIterable.from(names).filter(new Predicate<String>() {
			@Override
			public boolean apply(String input) {
				return input.equals("Lingling");
			}
		});
		
		Iterator<String> iter = namesBySearch.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		//Iterables usage.
		System.out.println(Iterables.contains(names, "Lingling"));
		
	}
}
