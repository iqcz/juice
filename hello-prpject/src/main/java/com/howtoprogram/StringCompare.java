package com.howtoprogram;

public class StringCompare {

	public static void main(String[] args) {
		String s1 = new String("hello"); // s1 is a copy of "hello"
		String s2 = "goodbye";
		String s3 = "Happy Birthday";
		String s4 = "happy birthday";

		// test regionMatches (case sensitive)
		if (s3.regionMatches(0, s4, 0, 5)) {
			System.out.println("First 5 characters of s3 and s4 match");
		} else {
			System.out.println("First 5 characters of s3 and s4 do not match");
		}

		// test regionMatches (ignore case)
		if (s3.regionMatches(true, 0, s4, 0, 5)) { // true means ignore string case.
			System.out.println("First 5 characters of s3 and s4 match with case ignored");
		} else {
			System.out.println("First 5 characters of s3 and s4 do not match");
		}
		
	} // end method main.
}
