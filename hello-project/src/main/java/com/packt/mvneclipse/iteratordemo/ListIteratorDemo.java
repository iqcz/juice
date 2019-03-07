package com.packt.mvneclipse.iteratordemo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 可修改的元素的迭代器
 * 反向输出list
 * @author TurtusLi
 *
 */
public class ListIteratorDemo {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Welcome");
		list.add("to");
		list.add("Beijing");
		
		ListIterator<String> iter = list.listIterator();
		 // 修改list里面元素的值,并将双向迭代器移到了list的尾部，才能实现后面的反向输出。
		while(iter.hasNext()) {
			String element = iter.next();
			iter.set(element + "@");
		}
		
		// 反向输出list
		while(iter.hasPrevious()) {
			String element = iter.previous();
			System.out.println(element + " ");
		}
	}

}
