package com.packt.mvneclipse.javainanutshell;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 推荐在复杂字符串操作中使用正则表达式。
 * 
 * 统计单词数量，用空格分隔。
 * 
 * @author Yanxue Li
 * 
 */
public class RegexTest {

    public static void main(final String[] args) {
	String str = "Tomorrow is another day.";

	Pattern pattern = Pattern.compile("\\b\\w+\\b");
	Matcher matcher = pattern.matcher(str);

	int wordsCount = 0;
	while (matcher.find()) {
	    wordsCount++;
	}

	System.out.printf("Word count: %d.\n", wordsCount);
    }
}
