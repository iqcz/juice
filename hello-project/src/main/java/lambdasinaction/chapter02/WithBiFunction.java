package lambdasinaction.chapter02;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 * As a side note, note that the abstract method in StringListFormatter takes two parameters and returns a value.
 * This is a good candidate for a BiFunction.
 * The WithBiFunction class in Listing 2.3 is a rewrite of the MethodReferenceDemo1 class
 * that eliminates the StringListFormatter interface entirely.
 * The formatAndPrint method has also been modified to accept a BiFunction as its first parameter.
 *
 * @author i324779
 */
public class WithBiFunction {

    public static void formatAndPrint(BiFunction<String, List<String>, String> formatter,
                                      String delimiter, List<String> list) {
        String formatted = formatter.apply(delimiter, list);
        System.out.println(formatted);
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Don", "King", "Kong");
        formatAndPrint(String::join, ", ", names);
    }
}
