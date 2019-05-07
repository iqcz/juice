package concurrency.extenthreaddpool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自己扩展ThreadPoolExecutor，打印详细的堆栈信息
 * @author i324779
 */
public class RightMain {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE, 0L,
                TimeUnit.SECONDS, new SynchronousQueue<>());

        for (int i = 0; i < 5; i++) {
            poolExecutor.execute(new DivTask(100, i));
//            poolExecutor.submit(new DivTask(100, i));
        }
    }
}
