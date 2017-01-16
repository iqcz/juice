package com.packt.mvneclipse.guava.collection;

import java.util.Set;

import com.google.common.collect.Sets;
import com.packt.mvneclipse.guava.model.Person;

public class SetsExample {

	public static void main(String[] args) {
//		Set<String> set1 = Sets.newHashSet("one", "two", "three"); // 元素多的set应该放在前面。in the first set.
//		Set<String> set2 = Sets.newHashSet("one", "two", "four");
//		
//		System.out.println(Sets.difference(set1, set2));
//		Sets.SetView<String> setView = Sets.symmetricDifference(set1, set2);// 两个set 做差集
//		for(String element : setView) {
//			System.out.println(element);
//		}
		
		Person p1 = new Person("Jolin", "Cai", 35, "F");
		Person p2 = new Person("Jolin", "Cai", 35, "F");
		Person p3 = new Person("Jay", "Zhou", 37, "M");
		
		Set<Person> sp1 = Sets.newHashSet(p1, p2);
		Set<Person> sp2 = Sets.newHashSet(p1, p3);
		
		System.out.println(sp1);
		System.out.println(sp2);
		System.out.println(Sets.symmetricDifference(sp1, sp2));
		
		System.out.println("-----------------------------------");
		
		Set<String> s1 = Sets.newHashSet("1","2","3");
		Set<String> s2 = Sets.newHashSet("3","2","4");
		
		Sets.SetView<String> sv = Sets.intersection(s1, s2);// 两个set 的交集
		System.out.println(sv);
	}

}
