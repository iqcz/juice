package com.howtoprogram;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class WordList {

    public static void main(String[] args) {
        String[] names = { "zhangsan", "lisi", "lisi", "wangwu", "zhaoliu", "ali", "bili" };

        // remove duplicated name in the array to add TreeSet.
        // and ordered by alphabetical order for String class
        Set<String> s = new TreeSet<>();
        Collections.addAll(s, names);
        System.out.println(s);
    }
}