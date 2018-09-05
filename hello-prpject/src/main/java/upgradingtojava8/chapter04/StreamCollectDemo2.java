package upgradingtojava8.chapter04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamCollectDemo2 {
    public static void main(String[] args) {
        String[] strings = { "a", "b", "c", "d" };
        Stream<String> stream1 = Stream.of(strings);
        List<String> list1 = stream1.collect(
                ArrayList::new,
                ArrayList::add,
                ArrayList::addAll);
        for (String s: list1) {
            System.out.println(s);
        }

        Stream<String> stream2 = Stream.of(strings);
        List<String> list2 = stream2.collect(
                ArrayList::new,
                ArrayList::add,
                ArrayList::addAll);
        for (String s: list2) {
            System.out.println(s);
        }
    }
}