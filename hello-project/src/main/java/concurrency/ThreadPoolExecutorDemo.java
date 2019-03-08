package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author i324779
 */
public class ThreadPoolExecutorDemo {

    private static final int THREAD_NUMBERS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        Runnable hellos = () -> {
            for (int i = 1; i <= 1000; i++) {
                System.out.println("Hello" + i);
            }
        };

        Runnable goodbyes = () -> {
            for (int i = 1; i <= 1000; i++) {
                System.out.println("Goodbye " + i);
            }
        };

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d")
                .build();
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(THREAD_NUMBERS,
                THREAD_NUMBERS * 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024),
                namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        threadPoolExecutor.execute(() -> System.out.println(Thread.currentThread().getName()));
        threadPoolExecutor.execute(hellos);
        threadPoolExecutor.execute(goodbyes);

        threadPoolExecutor.shutdown();
    }
}
