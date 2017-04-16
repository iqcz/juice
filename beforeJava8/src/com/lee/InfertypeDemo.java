package com.lee;

import java.util.Collections;
import java.util.List;

/**
 * Type parameters in method calls
 * The were some situations prior to Java 8 where the compiler couldn't infer types.
 * One of these was when calling methods with generic type parameters as arguments.
 * 
 * @author TurtusLi
 *
 */
public class InfertypeDemo {

    public static void main(String[] args) {
	List<String> names = Collections.emptyList(); // compiles in Java 7
	
//	processNames(Collections.emptyList()); // get error in java 7,but OK in java 8
	processNames(Collections.<String>emptyList()); 
    }
    
    static void processNames(List<String> names) {
	    System.out.println("hello " + names);
    }

}