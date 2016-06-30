package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JavaFuncDemo {

	public static void main(String[] args) {
		Predicate<String> nonEmptyPredicate = s -> !s.isEmpty();

		List<String> strList = new ArrayList<>();
		strList.add("one");
		strList.add("two");
		strList.add("three");
		strList.add("");
		strList.add("five");

		List<String> nonEmptyList = filter(strList, nonEmptyPredicate);
		System.out.println(nonEmptyList);

		System.out.println("================");
		// Function<String, Integer> myFunction = (t) -> (t.length());
		List<Integer> lengthList = map(strList, (t) -> t.length());
		System.out.println(lengthList);

		System.out.println("================");
		List<String> str = Arrays.asList("a", "b", "A", "B");
		// str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		str.sort(String::compareToIgnoreCase);
		System.out.println(str);

		System.out.println("================");
//		BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
		
		BiPredicate<List<String>, String> contains = List::contains;
		
		System.out.println(contains.test(str, "d"));
		
		System.out.println("================");
		
		Supplier<String> c1 = String::new;
		String s1 = c1.get();
		System.out.println("s1=" + s1);
		
		Function<String, String> c2 = String::new;
		String s2 = c2.apply("hello");
		System.out.println("s2=" + s2);
		
		System.out.println("================");
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		Function<Integer, Integer> h = f.andThen(g);
		Function<Integer, Integer> k = f.compose(g);
		System.out.println(h.apply(2));
		System.out.println(k.apply(2));
	
	}

	/**
	 * demo for Predicate as parameter.
	 * 
	 * @param list
	 * @param p
	 * @return
	 */
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<T>();
		for (T t : list) {
			if (p.test(t)) {
				results.add(t);
			}
		}

		return results;
	}

	/**
	 * demo Function as parameter.
	 * 
	 * @param list
	 * @param f
	 * @return the list hold strings' length.
	 */
	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for (T t : list) {
			result.add(f.apply(t));
		}

		return result;
	}

}