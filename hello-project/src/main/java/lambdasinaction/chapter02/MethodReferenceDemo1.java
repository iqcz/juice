package lambdasinaction.chapter02;

import java.util.Arrays;
import java.util.List;

/** 
 * The function is the same as NoMethodRef.java,
 * but use String.join as method reference.
 * @author i324779
 *
 */
public class MethodReferenceDemo1 {

    @FunctionalInterface
    interface StringListFormatter {
	String format(String delimiter, List<String> list);
    }

    public static void formatAndPrint(StringListFormatter formatter, String delimiter, List<String> list) {
	String formatted = formatter.format(delimiter, list);
	System.out.println(formatted);
    }

    public static void main(String[] args) {
	List<String> names = Arrays.asList("Don", "King", "Kong");
	formatAndPrint(String::join, ", ", names);
    }
}