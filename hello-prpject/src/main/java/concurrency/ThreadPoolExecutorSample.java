package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorSample {

    private static final int count = 200_000;

    public static void main(String[] args) {
	// use ThreadPoolExecutor
	/*
	long startTime = System.currentTimeMillis();
	final List<Integer> list = new ArrayList<>();
	ThreadPoolExecutor tp = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS,
		new LinkedBlockingQueue<Runnable>(count));
	final Random random = new Random();
	for (int i = 0; i < count; i++) {
	    tp.execute(() -> list.add(random.nextInt()));
	}
	tp.shutdown();
	try {
	    tp.awaitTermination(1, TimeUnit.DAYS);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	System.out.println(System.currentTimeMillis() - startTime);
	System.out.println(list.size());
	*/
	
	// not use ThreadPoolExecutor, just create thread directly.
	long startTime = System.currentTimeMillis();
	final List<Integer> list = new ArrayList<>();
	final Random random = new Random();
	for (int i = 0; i < count; i++) {
	    Thread thread = new Thread() {
		@Override
		public void run() {
		    list.add(random.nextInt());
		}
	    };
	    thread.start();
	    
	    try {
		thread.join();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	
	System.out.println(System.currentTimeMillis() - startTime);
	System.out.println(list.size());
    }
}
