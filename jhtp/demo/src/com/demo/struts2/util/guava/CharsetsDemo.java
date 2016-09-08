package com.demo.struts2.util.guava;

import com.google.common.base.Charsets;
import com.google.common.base.Functions;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;

public class CharsetsDemo {

	public static void main(String[] args) {

		System.out.println(Charsets.UTF_8);
		
		System.out.println(Strings.padEnd("foo", 6, 'x'));
		
		System.out.println(Strings.nullToEmpty(null));
		
		System.out.println(MoreObjects.firstNonNull(null, "hello"));
		
	}

}
