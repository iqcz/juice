package com.packt.mvneclipse.stringdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 根据指定连接符号把一集合里的所有元素连接起来。
 * @author TurtusLi
 *
 */
public class JoinerDemo {

	public static void main(String[] args) {

		List<String> strList = new ArrayList<>();
		strList.add("One");
		strList.add(null);
		strList.add("Two");
		strList.add("");
		strList.add("Three");
		
		System.out.println(buildString(strList, ";").toString());
		System.out.println(StandardCharsets.UTF_8);
		
		
		try (InputStream input = new FileInputStream("/Users/ben/details.txt")){
			input.available();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static String buildString(List<String> stringList, String delimiter) {
		StringBuilder builder = new StringBuilder();

		for (String s : stringList) {
			if (s != null) {
				builder.append(s).append(delimiter);
			}
		}

		builder.setLength(builder.length() - delimiter.length());
		return builder.toString();
	}

}
