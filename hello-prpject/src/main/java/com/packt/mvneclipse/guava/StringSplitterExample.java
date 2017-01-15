package com.packt.mvneclipse.guava;

import java.util.regex.Pattern;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

public class StringSplitterExample {

	public static void main(String[] args) {
		testSplitterPattern();
		System.out.println("--------------------");
		testSplit();
		System.out.println("--------------------");
		testSplitTrimResults();
		System.out.println("--------------------");
		testSplitOnCharacterOmitMissing();
	}

	/**
	 * 根据正则表达式对字符串进行分隔（以数字）
	 */
	public static void testSplitterPattern() {
		String pattern = "\\d+";
		String text = "foo123bar45678baz";
		Iterable<String> values = Splitter.on(Pattern.compile(pattern)).split(text);
//		Iterable<String> values = Splitter.onPattern(pattern).split(text);

		for (String value : values) {
			System.out.println(value);
		}
	}

	/**
	 * 如果不是正则表达式，可以直接使用以下方法。
	 */
	public static void testSplit() {
		String delimiter = "&";
		String text = "foo&bar&baz";
		Iterable<String> values = Splitter.on(delimiter).split(text);
		
		for (String value : values) {
			System.out.println(value);
		}
	}
	
	/**
	 * 分隔以后，再去掉指定的字符。
	 */
	public static void testSplitTrimResults() {
		String delimiter = "&";
        String text = "1foo&bar2&2baz3";
        Iterable<String> values = Splitter.on(delimiter).trimResults(CharMatcher.JAVA_DIGIT).split(text);
        
        for (String value : values) {
			System.out.println(value);
		}
	}

	/**
	 * 忽略为空的元素
	 */
	public static void testSplitOnCharacterOmitMissing() {
		char delimiter = '|';
        String text = "foo|bar|||baz";
        
        Iterable<String> values = Splitter.on(delimiter).omitEmptyStrings().split(text);
        
        for (String value : values) {
			System.out.println(value);
		}
	}
}
