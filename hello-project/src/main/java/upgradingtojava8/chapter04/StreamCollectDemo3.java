package upgradingtojava8.chapter04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamCollectDemo3 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("wang", "li", "zhao");
        System.out.println(names);

        AtomicInteger counter = new AtomicInteger();

        Supplier<List<String>> supplier = () -> {
            System.out.println("supplier called");

            return new ArrayList<>() {
                private static final long serialVersionUID = -688012119325500423L;
                private int id = counter.getAndIncrement();

                @Override
                public boolean add(String e) {
                    System.out.println("\"add\" called for " + e + " on ArrayList " + id);
                    return super.add(e);
                }

                @Override
                public boolean addAll(Collection<? extends String> c) {
                    System.out.println("\"addAll\" called" + " on ArrayList " + id);
                    return super.addAll(c);
                }
            };
        };

        String[] strings = { "a", "b", "c", "d" };
        Stream<String> stream1 = Stream.of(strings).parallel();

        List<String> list1 = stream1.collect(supplier, List::add,
                List::addAll);
        // equals below code.
//        List<String> list1 = stream1.collect(supplier, (a1, b1) -> a1.add(b1),
//                (a2, b2) -> a2.addAll(b2));

        for (String s : list1) {
            System.out.println(s);
        }
    }
}
