package other;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaDemo {

	public static void main(String ...args) {
		List<Dish> menu = Arrays.asList(
			    new Dish("pork", false, 800, Dish.Type.MEAT),
			    new Dish("beef", false, 700, Dish.Type.MEAT),
			    new Dish("chicken", false, 400, Dish.Type.MEAT),
			    new Dish("french fries", true, 530, Dish.Type.OTHER),
			    new Dish("rice", true, 350, Dish.Type.OTHER),
			    new Dish("season fruit", true, 120, Dish.Type.OTHER),
			    new Dish("pizza", true, 550, Dish.Type.OTHER),
			    new Dish("prawns", false, 300, Dish.Type.FISH),
			    new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		
		long count = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .distinct()
                .limit(3)
                .count();
		
		System.out.println(count);
		
		List<Dish> vegetarianDishes = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
		System.out.println(vegetarianDishes);
		
		System.out.println("+++++++++++");
		List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .collect(Collectors.toList());
		
		System.out.println(dishes);
		
		System.out.println("+++++++++++");
		List<Dish> dishesLimit = menu.stream()
				.filter(d -> d.getCalories() > 300)
				.limit(3)
				.collect(Collectors.toList());
		
		System.out.println(dishesLimit);
		
		System.out.println("+++++++++++");
		List<Dish> dishesSkip = menu.stream()
				.filter(d -> d.getCalories() > 300)
				.skip(3)
				.collect(Collectors.toList());
		
		System.out.println(dishesSkip);
		
		System.out.println("+++++++++++");
		List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
		List<Integer> wordsLength = words.stream().map(String::length).collect(Collectors.toList());
		System.out.println(wordsLength);
		
		System.out.println("+++++++++++");
		List<String> uniqueCharacters = words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
		System.out.println(uniqueCharacters);
		
		System.out.println("+++++++++++");
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> squares = numbers.stream().map(n -> n * n).collect(Collectors.toList());
		System.out.println(squares);
		
		System.out.println("+++++++++++");
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[] { i, j }))
				.collect(Collectors.toList());
		
		System.out.println("+++++++++++");
		String s = "";
		String s1 = s.toLowerCase();
		System.out.println("====" + s1);
	}
}

