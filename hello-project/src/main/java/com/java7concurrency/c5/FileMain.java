package com.java7concurrency.c5;

import java.util.concurrent.TimeUnit;

/**
 * @author i324779
 *         Created on 2018-08-03
 */
public class FileMain {
    public static void main(String... args) {
        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);
        // start one thread.
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
