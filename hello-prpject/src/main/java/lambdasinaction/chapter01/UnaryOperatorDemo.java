package lambdasinaction.chapter01;

import java.util.function.UnaryOperator;

/**
 * The UnaryOperator interface is another specialization of Function 
 * whose operand type is the same as the return type. 
 * Its declaration is as follows.
 * @author i324779
 *
 */
public class UnaryOperatorDemo {

    public static void main(String[] args) {
        UnaryOperator<String> appendSomething = str -> str + "->end";

        System.out.println(appendSomething.apply("Ready to "));
    }
}
