package other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class AppleDemo {

	public static void main(String[] args) {

		Comparator<Apple> byWeight = new Comparator<Apple>() {
			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
		};

		Comparator<Apple> newByWeight = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());
		
		List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
		inventory.sort(Comparator.comparing(Apple::getWeight));

		System.out.println(inventory);

		List<String> str = Arrays.asList("a", "b", "A", "B");
		str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		str.sort(String::compareToIgnoreCase);

		Supplier<Apple> s1 = Apple::new;
		Apple a1 = s1.get();

		Function<Integer, Apple> f1 = Apple::new;
		Apple a2 = f1.apply(100);

		BiFunction<Integer, String, Apple> b1 = Apple::new;
		Apple a3 = b1.apply(100, "green");
		System.out.println(a3);
	}

}
