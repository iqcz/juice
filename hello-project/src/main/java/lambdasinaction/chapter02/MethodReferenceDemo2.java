package lambdasinaction.chapter02;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo2 {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana");
        // with lambda expression
        fruits.forEach((name) -> System.out.println(name));

        // with method reference
        fruits.forEach(System.out::println);
    }
}