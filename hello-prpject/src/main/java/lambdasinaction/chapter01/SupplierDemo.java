package lambdasinaction.chapter01;

import java.util.Random;
import java.util.function.Supplier;

/**
 * A Supplier takes no parameter and returns a value. 
 * Implementations must override its get abstract method 
 * and returns an instance of the interface’s type parameter.

 * @author i324779
 *
 */
public class SupplierDemo {
    public static void main(String[] args) {
	Supplier<Integer> oneDigitRandom = () -> {
	    Random random = new Random();
	    return random.nextInt(10);
	};
	for (int i = 0; i < 5; i++) {
	    System.out.println(oneDigitRandom.get());
	}
    }
}