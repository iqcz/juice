package concurrency.extenthreaddpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 出现除0的情况
 *
 * @author i324779
 */
public class WrongMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                0L, TimeUnit.SECONDS, new SynchronousQueue<>());

        for (int i = 0; i < 5; i++) {
            // 没有任何出错信息，不好排查
            poolExecutor.submit(new DivTask(100, i));

            // 改造的方法1：改用execute方法，抛出详细异常信息
//            poolExecutor.execute(new DivTask(100, i));

            // 改造的方法2：
//            Future re = poolExecutor.submit(new DivTask(100, i));
//            System.out.println(re.get());

            // 改造的方式3：自己扩展ThreadPoolExecutor线程池
            // see RightMain.java
        }
    }
}
