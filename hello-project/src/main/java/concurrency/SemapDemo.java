package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author i324779
 */
public class SemapDemo implements Runnable {
    private final Semaphore semaphore = new Semaphore(5);


    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ": done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemapDemo demo = new SemapDemo();
        for (int i = 0; i < 20; i++) {
            exec.submit(demo);
        }

        exec.shutdown();
    }
}
