package lambdasinaction.mydemo;

// Fig. 17.19: RandomIntStream.java
// Rolling a die 6,000,000 times with streams
import java.security.SecureRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RandomIntStream {

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();

        // roll a die 6,000,000 times and summarize the results
        System.out.printf("%-6s%s%n", "Face", "Frequency");
        // boxed方法的作用：
        random.ints(100, 1, 100).boxed()
                // Java does not allow primitive values in collections,
                // so to summarize the results in a Map,
                // we must first convert the IntStream to a Stream<Integer>.
                // We do this by calling IntStream method boxed.
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((face, frequency) -> System.out.printf("%-6d%d%n", face, frequency));
    }
} // end class RandomIntStream
