package upgradingtojava8.chapter04;

import java.util.stream.Stream;

public class StreamConcatDemo {

    public static void main(String... args) {
	Stream<String> stream1 = Stream.of("January", "Christie", "abc");
	Stream<String> stream2 = Stream.of("Okanagan", "Sydney", "Alpha");

	Stream.concat(stream1, stream2)
		.sorted(String::compareToIgnoreCase)// method reference
		.forEach(System.out::println);
    }
}
