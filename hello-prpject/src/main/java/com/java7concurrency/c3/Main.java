package com.java7concurrency.c3;

/**
 * @author i324779
 *         Created on 2018-08-02
 */
public class Main {
    public static void main(String... args) {
        Thread task = new PrimeGenerator();
        task.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }
}
