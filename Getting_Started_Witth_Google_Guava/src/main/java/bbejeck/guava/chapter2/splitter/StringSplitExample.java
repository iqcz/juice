package bbejeck.guava.chapter2.splitter;

import java.util.Arrays;

/**
 * User: Bill Bejeck Date: 7/16/13 Time: 11:17 PM
 */
public class StringSplitExample {

	public static void main(String[] args) {
		
		// use the JDK self  method to split the String.
		// need to consider exception.
		// not good.
		String commaSeparatedString = "Foo,,Bar,,Baz,,,";
		String[] words = commaSeparatedString.split(",");
		
		System.out.println(Arrays.toString(words));
	}
}
