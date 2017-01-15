package com.packt.mvneclipse.guava;

import com.google.common.base.Strings;

public class StringsExample {

	public static void main(String[] args) {

		System.out.println(Strings.padEnd("99", 6, '0'));
		System.out.println(Strings.padStart("99", 6, '0'));
		System.out.println(Strings.isNullOrEmpty(null));
		System.out.println(Strings.isNullOrEmpty(""));
		System.out.println(Strings.nullToEmpty(Strings.nullToEmpty(null)));
		System.out.println(Strings.emptyToNull(""));
	}

}
