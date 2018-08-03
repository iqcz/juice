package com.java7concurrency.c4;

import java.util.concurrent.TimeUnit;

/**
 * @author i324779
 *         Created on 2018-08-02
 */
public class Main {
    public static void main(String... args) {
        FileSearch searcher = new FileSearch("/Users/User/juice/hello-prpject/", "obj.txt");
        Thread thread = new Thread(searcher);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}

