package com.java7concurrency.c6;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author yourname
 *         Created on 2018-08-03
 */
public class NetworkConnectionsLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Beginning network connection sources loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("network connection loading has finished: %s\n", new Date());
    }
}
