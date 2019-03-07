package com.packt.mvneclipse.javainanutshell;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/**
 * 
 * @author Phideon Lee
 * 可以定义一个无属性和方法的接口，
 * 此接口只是作为一个标记
 * 例如RandomAccess接口，当ArrayList实现此接口以后，表明用 for 循环快于 foreach。
 * 具体参见 API。
 *
 */


public class InterfaceDemo {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("liyi");
		names.add("liner");
		names.add("zhangsan");

		if (names.size() > 2 && !(names instanceof RandomAccess)) {
			names = new ArrayList<>(names);
		}

		// legal
		List<?> books = new ArrayList<String>();
//		List<?> companies = new ArrayList<T>();
		
		String[] words = {"Hello", "world"};
		Object[] objects = words;
		
		@NotNull String safeString = null;
		
		
		
	}
	
	private List<? extends Object> getBooks() {
		return null;
	}
	
	public static <T> T coma(T a, T b) {
		return a;
	}
}
