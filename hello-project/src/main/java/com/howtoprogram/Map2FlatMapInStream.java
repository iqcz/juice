package com.howtoprogram;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream 中 map 和 flatMap 区别。
 * @author i324779
 */
public class Map2FlatMapInStream {

    public static void main(String[] args) {
        List<String> words = List.of("Hello", "World", "Stream");

        // map 方法将作用域每个元素，这样就产生了一个包含最终结果的新流。
        Stream<String> lowercaseWords = words.stream().map(String::toLowerCase);

        // 包含多个流的流。如[...["H","e","l","l","o], ["W","o","r","l","d"],...]，
        // 要想要将其展开为一个只包含字符串的流如[..."H","e","l","l","o, "W","o","r","l","d",...]，
        // 应该使用flatMap方法
        Stream<Stream<String>> codePoints = words.stream().map(Map2FlatMapInStream::codePoints);
        codePoints("Hello").forEach(System.out::println);

        Stream<String> flatResult = words.stream().flatMap(Map2FlatMapInStream::codePoints);
    }

    public static Stream<String> codePoints(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = s.offsetByCodePoints(i, 1);
            result.add(s.substring(i, j));
            i = j;
        }

        return result.stream();
    }
}
