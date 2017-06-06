package com.packt.ming;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * 中文拼音排序
 * 
 * @author i324779
 *
 */
public class SimpleChineseSort {

	@SuppressWarnings("rawtypes")
	private final static Comparator CHINA_CPMPARE = Collator.getInstance(Locale.CHINA);

	/**
	 * 使用 List 排序
	 */
	@SuppressWarnings("unused")
	private static void sortList() {
		List<String> list = Arrays.asList("张三", "李四", "王五");
		Collections.sort(list, CHINA_CPMPARE);

		for (String str : list) {
			System.out.println(str);
		}
	}

	/**
	 * 使用数组排序
	 */
	private static void sortArray() {
		String[] arr = { "张三", "李四", "王五" };
		Arrays.sort(arr, CHINA_CPMPARE);

		for (String str : arr) {
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		sortList();
		sortArray();
	}

}
