package com.howtoprogram;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsSortMethd {

    public static void main(String[] args) {
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        List<String> list = Arrays.asList(suits);

        System.out.println("Unsorted List: " + list);

        Collections.sort(list);
        System.out.println("Sorted List:" + list);

        list.sort(Collections.reverseOrder());
        System.out.println("Reversed List: " + list);
    }
}
