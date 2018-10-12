package com.howtoprogram;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 给定一个int类型的数组，计算大于指定元素的个数，实用IntStream来实现。
 * 注意：不是Integer类型。
 * @author i324779
 *
 */
public class BigThanNumbersCount {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 5, 6, 7, 90, 122 };
        long count = IntStream.of(nums).filter(e -> e > 5).count();
        System.out.println(count);

        Stream<String> stream1 = Stream.of("January", "Christie");
        Stream<String> stream2 = Stream.of("Okanagan", "Sydney", "Alpha");
        Stream.concat(stream1, stream2).sorted().forEach(System.out::println);
    }

}
