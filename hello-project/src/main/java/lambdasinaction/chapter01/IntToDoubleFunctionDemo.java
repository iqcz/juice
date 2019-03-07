package lambdasinaction.chapter01;

import java.util.function.IntToDoubleFunction;

/**
 * Represents a function that accepts an int-valued argument and produces a double-valued result.
 * This is the int-to-double primitive specialization for Function.
 *  
 * IntToDoubleFunction interface can be used to create a function that accepts an int and returns a double.
 * @author i324779
 *
 */
public class IntToDoubleFunctionDemo {

    public static void main(String[] args) {
        IntToDoubleFunction celciusToFahrenheit = (input) -> 1.8 * input + 32;
        int celcius = 100;
        double fahrenheit = celciusToFahrenheit.applyAsDouble(celcius);
        System.out.println(celcius + "\u2103" + " = " + fahrenheit + "\u2109\n");
    }
}