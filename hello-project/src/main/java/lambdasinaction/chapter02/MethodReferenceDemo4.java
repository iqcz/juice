package lambdasinaction.chapter02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Supplier;

/**
 * Need a method to convert an Integer array to a Collection 
 * and you need to be able to determine 
 * whether the resulting collection is a List or a Set. 
 * To this end, you can create the arrayToCollection method.
 * 
 * @author i324779
 *
 */

public class MethodReferenceDemo4 {

    /**
     * the implementing classes of the collection
     * @param supplier
     * @param numbers
     * @return
     */
    public static Collection<Integer> arrayToCollection(Supplier<Collection<Integer>> supplier,
            Integer[] numbers) {
        Collection<Integer> collection = supplier.get();

        for (int i : numbers) {
            collection.add(i);
        }

        return collection;
    }

    public static void main(String[] args) {
        Integer[] array = { 1, 8, 5 };
        Collection<Integer> col1 = arrayToCollection(ArrayList::new, array);
        System.out.println("Natural order");
        col1.forEach(System.out::println);

        System.out.println("=======================");

        System.out.println("Ascending order");
        Collection<Integer> col2 = arrayToCollection(HashSet::new, array);
        col2.forEach(System.out::println);
    }
}