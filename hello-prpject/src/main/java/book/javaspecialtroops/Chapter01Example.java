package book.javaspecialtroops;

import java.util.Arrays;

/**
 * String 
 * equals
 * ==
 * 各种情况
 * @author Yanxue.Li
 *
 */
public class Chapter01Example {

	public static void main(String[] args) {
		test1();

		System.out.println("-------");
		test2();
		System.out.println("-------");
		test3();
		
		int[] a = {1,2, 3};
		Arrays.copyOf(a, 1);
	}

	private static void test1() {
		String a = "a" + "b" + 1;
		String b = "ab1";

		System.out.println(a == b);
	} // end method test1

	private static String getA() {
		return "a";
	} // end method getA

	public static void test2() {
		String a = "a";
		final String c = "a";

		String b = a + "b";
		String d = c + "b";
		String e = getA() + "b";

		String compare = "ab";

		System.out.println(b == compare);
		System.out.println(d == compare);
		System.out.println(e == compare);
	} // end method test2

	public static void test3() {
		String a = "a";
		String b = a + "b";
		String c = "ab";
		String d = new String(b);

		System.out.println(b == c);
		System.out.println(c == d);
		System.out.println(c == d.intern());
		System.out.println(b.intern() == d.intern());
	}
}
