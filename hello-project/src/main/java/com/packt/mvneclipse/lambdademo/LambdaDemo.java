package com.packt.mvneclipse.lambdademo;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo {

	public static void main(String[] args) {

		String[] persons = {"zhang3", "li4", "wang5", "zhao6"};
		List<String> players = Arrays.asList(persons);
		
		players.forEach(player -> System.out.println(player));
	}

}
