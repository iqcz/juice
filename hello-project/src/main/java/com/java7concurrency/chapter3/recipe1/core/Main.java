package com.java7concurrency.chapter3.recipe1.core;

import com.java7concurrency.chapter3.recipe1.task.Job;
import com.java7concurrency.chapter3.recipe1.task.PrintQueue;

/**
 * Main class of the example.
 */
public class Main {

    private static final int THREAD_COUNT = 10;
    /**
     * Main method of the class. Run ten jobs in parallel that
     * send documents to the print queue at the same time.
     */
    public static void main(String... args) {

        // Creates the print queue
        PrintQueue printQueue = new PrintQueue();

        // Creates ten Threads
        Thread[] thread = new Thread[THREAD_COUNT];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        // Starts the Threads
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }

}
