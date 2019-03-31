package com.howtoprogram;

import java.util.PrimitiveIterator;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/**
 * 看运行结果
 * @author i324779
 *
 */
public class SquareGenerator implements IntSupplier {

    private int current = 1;

    @Override
    public synchronized int getAsInt() {
        int thisCurrent = current * current;
        current++;

        return thisCurrent;
    }

    public static void main(String[] args) {
        IntStream squars = IntStream.generate(new SquareGenerator());

        PrimitiveIterator.OfInt stepThrough = squars.iterator();

        for (int i = 0; i < 10; i++) {
            System.out.println(stepThrough.nextInt());
        }

        System.out.println("First iterator done...");

        // We can go on as long as we like...
        for (int i = 0; i < 10; i++) {
            System.out.println(stepThrough.nextInt());
        }
    }

}
