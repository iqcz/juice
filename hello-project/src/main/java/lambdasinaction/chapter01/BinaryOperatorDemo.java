package lambdasinaction.chapter01;

import java.util.function.BinaryOperator;

/**
 * BinaryOperator is a specialization of BiFunction.
 * BinaryOperator represents an operation with two operands of the same type
 * <p>
 * and returns a result that has the same type as the operands.
 *
 * @author i324779
 */
public class BinaryOperatorDemo {

    public static void main(String[] args) {
        BinaryOperator<String> sameType = (str1, str2) -> str1 + ", " + str2 + ".";
        System.out.println(sameType.apply("Hello", "yaoyao"));
    }

}
