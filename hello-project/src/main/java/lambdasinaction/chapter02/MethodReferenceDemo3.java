package lambdasinaction.chapter02;

import java.util.Arrays;

/**
 * Reference to An Instance Method where No Object Reference Is Available

 * @author i324779
 *
 */
public class MethodReferenceDemo3 {

    public static void main(String[] args) {
	String[] names = { "Alexis", "anna", "Kyleen" };

	Arrays.sort(names, String::compareToIgnoreCase);
	for (String name : names) {
	    System.out.println(name);
	}
    }
}