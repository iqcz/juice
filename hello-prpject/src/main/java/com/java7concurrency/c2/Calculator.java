package com.java7concurrency.c2;

/**
 * @author i324779
 *         Created on 2018-08-02
 */
public class Calculator implements Runnable {
    private int number;

    public Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%s: %d * %d = %d\n",
                    Thread.currentThread().getName(), number, i, i * number);
        }
    }
}
