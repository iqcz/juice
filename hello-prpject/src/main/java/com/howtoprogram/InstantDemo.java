package com.howtoprogram;

import java.time.Duration;
import java.time.Instant;

public class InstantDemo {

    public static void main(String[] args) {
        Instant start = Instant.now();

        // do something here
        for (int i = 0; i < 1000000; i++) {
            new String();
        }

        Instant end = Instant.now();

        System.out.println(Duration.between(start, end).toMillis());
    }
}
