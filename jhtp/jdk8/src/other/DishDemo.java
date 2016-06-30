package other;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DishDemo {

	public static void main(String... args) {

		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT), 
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER), 
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), 
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), 
				new Dish("salmon", false, 450, Dish.Type.FISH));

		System.out.println(System.currentTimeMillis());
		List<String> lowCaloricDishesName = menu.parallelStream()
				.filter(s -> s.getCalories() < 400)
				.sorted(comparing(Dish::getCalories))
				.map(Dish::getName)
				.collect(Collectors.toList());
		System.out.println(System.currentTimeMillis());
		System.out.println(lowCaloricDishesName);
		
		System.out.println(System.currentTimeMillis());
		List<String> lowCaloricDishesName1 = menu.stream()
				.filter(s -> s.getCalories() < 400)
				.sorted(comparing(Dish::getCalories))
				.map(Dish::getName)
				.collect(Collectors.toList());
		System.out.println(System.currentTimeMillis());
		System.out.println(lowCaloricDishesName1);
		
		System.out.println("============");
		Map<Dish.Type, List<Dish>> dishesByType =
			    menu.stream().collect(Collectors.groupingBy(Dish::getType));
		
		System.out.println(dishesByType);
		
		List<Dish> vegDishList = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
		
		System.out.println(vegDishList);
		
		
		List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
		List<Integer> wordLengths = words.stream()
		                                 .map(String::length)
		                                 .collect(Collectors.toList());
		
		System.out.println(wordLengths);
		
		
		// bad codes
		/*
		List<String[]> disCharacters = words.stream().map(word -> word.split(""))
		.distinct()
		.collect(Collectors.toList());
		*/
		
		
		String[] arrayOfWords = {"Goodbye", "word"};
		List<String> streamOfWords = Arrays.asList(arrayOfWords);
		
		List<String> splitedStr = streamOfWords.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
		
		System.out.println(splitedStr);
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> squares = numbers.stream().map(n -> n*n).collect(Collectors.toList());
		System.out.println(squares);
		
		
		Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
		System.out.println(dish);

	}
}
