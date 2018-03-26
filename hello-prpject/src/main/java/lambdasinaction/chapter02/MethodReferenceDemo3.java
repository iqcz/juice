package lambdasinaction.chapter02;

import java.util.Arrays;

public class MethodReferenceDemo3 {

    public static void main(String[] args) {
	String[] names = { "Alexis", "anna", "Kyleen" };

	Arrays.sort(names, String::compareToIgnoreCase);
	for (String name : names) {
	    System.out.println(name);
	}
    }
}