package entity;

/**
 * It’s possible in Java to overload methods, 
 * so you have multiple methods with the same name but different signatures. 
 * This approach poses a problem for parameter-type inference 
 * because it means that there are several types that could be inferred. 
 * In these situations javac will pick the most specific type for you
 * @author i324779
 *
 */
public class OverloadResolution {

    public static void main(String[] args) {
	OverloadResolution or = new OverloadResolution();
	or.overloadedMethod("abc");
    }

    private void overloadedMethod(Object o) {
	System.out.print("Object");
    }

    private void overloadedMethod(String s) {
	System.out.print("String");
    }
}
