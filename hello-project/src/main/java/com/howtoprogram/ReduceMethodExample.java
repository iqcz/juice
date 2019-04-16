package com.howtoprogram;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 统计每个单词的平均长度
 * @author i324779
 */
public class ReduceMethodExample {

    public static void main(String[] args) {
        String[] billyQuotes = { "For Brutus is an honourable man",
                "Give me your hands if we be friends and Robin shall restore amends",
                "Misery acquaints a man with strange bedfellows" };

        List<String> quotes = Arrays.asList(billyQuotes);

        // Create a temporary collection for our words，this place is regex expression.
        List<String> words = quotes.stream().flatMap(line -> Stream.of(line.split(" +")))
                .collect(Collectors.toList());

        // 注意，flatMap与map使用上的区别
        List<String[]> words2 = quotes.stream().map(line -> line.split(" +"))
                .collect(Collectors.toList());

        long wordCount = words.size();

        // The cast to double is only needed to prevent Java from using
        // integer division
        double aveLength = ((double) words.stream().map(String::length)
                .reduce(0, Integer::sum)) / wordCount;
        System.out.println("Average word length: " + aveLength);
    }
} // end class ReduceMethodExample
