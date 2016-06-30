package other;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MyPredicateDemo {

	public static void main(String... args) {

		List<String> myList = new ArrayList<>();
		myList.add("one");
		myList.add("A");
		myList.add("FOUR");

		List<String> results = filter(myList, s -> s.length() > 3);

		System.out.println(results);
		
		forEach(myList, i -> System.out.println(i));
		
		List<Integer> strsLength = map(myList, s -> s.length());
		System.out.println(strsLength);
		
	}

	/**
	 * 
	 * @param list
	 * @param pre
	 * @return
	 */
	public static <T> List<T> filter(List<T> list, MyPredicate<T> pre) {
		List<T> results = new ArrayList<>();
		for (T e : list) {
			if (pre.test(e)) {
				results.add(e);
			}
		}
		return results;
	}
	
	/**
	 * Consumer demo
	 * @param list
	 * @param c
	 */
	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for(T e: list) {
			c.accept(e);
		}
	}
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> fun) {
		List<R> results = new ArrayList<>();
		for(T e: list) {
			results.add(fun.apply(e));
		}
		
		return results;
	}
}
