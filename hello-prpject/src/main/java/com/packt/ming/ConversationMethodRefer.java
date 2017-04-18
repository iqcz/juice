package com.packt.ming;

public class ConversationMethodRefer {

	public static void main(String[] args) {

		System.out.println(convert(3, String::valueOf));
	}

	public static String convert(Integer number, Conversation function) {
		return function.apply(number);
	}
}
