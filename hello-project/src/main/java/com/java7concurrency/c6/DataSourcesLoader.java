package com.java7concurrency.c6;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author i324779
 *         Created on 2018-08-03
 */
public class DataSourcesLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Beginning data sources loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Data sources loading has finished: %s\n", new Date());
    }
}
