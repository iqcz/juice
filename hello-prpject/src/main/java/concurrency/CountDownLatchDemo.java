package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A countdown latch causes one or more threads to wait at a “gate” 
 * until another thread opens this gate, at which point these other threads can continue.
 *  It consists of a count and operations for “causing a thread to wait until the count reaches zero” 
 *  and “decrementing the count.”
 * @author i324779
 *
 */
public class CountDownLatchDemo {
    final static int NTHREADS = 3; // TODO how to evaluate this number?

    public static void main(String[] args) {
	final CountDownLatch startSignal = new CountDownLatch(1);
	final CountDownLatch doneSignal = new CountDownLatch(NTHREADS);
	
	Runnable r = new Runnable() {
	    @Override public void run() {
		try {
		    report("entered run()");
		    startSignal.await(); // wait until told to ...
		    report("doing work"); // ... proceed
		    Thread.sleep((int) (Math.random() * 1000));
		    doneSignal.countDown(); // reduce count on which
					    // main thread is ...
		} // waiting
		catch (InterruptedException ie) {
		    System.err.println(ie);
		}
	    }

	    void report(String s) {
		System.out.println(System.currentTimeMillis() + ": " + Thread.currentThread() + ": " + s);
	    }
	};
	
	ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
	for (int i = 0; i < NTHREADS; i++) {
	    executor.execute(r);
	}
	
	try {
	    System.out.println("main thread doing something");
	    Thread.sleep(1000); // sleep for 1 second
	    startSignal.countDown(); // let all threads proceed
	    System.out.println("main thread doing something else");
	    doneSignal.await(); // wait for all threads to finish
	    executor.shutdownNow();
	} catch (InterruptedException ie) {
	    System.err.println(ie);
	}
    }
}