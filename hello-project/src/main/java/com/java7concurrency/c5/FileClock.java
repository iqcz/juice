package com.java7concurrency.c5;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author i324779
 *         Created on 2018-08-03
 */
public class FileClock implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s -> %s\n", Thread.currentThread().getName(), new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.printf("The FileClock has been interrupted.\n");
            }
        }
    }
}
