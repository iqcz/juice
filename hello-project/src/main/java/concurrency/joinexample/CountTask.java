package concurrency.joinexample;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 分而治之：Fork/Join框架
 * 对应一个ForkJoinPool
 * 可以向ForkJoinPool线程池提交一个ForkJoinTask任务。
 * ForkJoinTask支持fork方法分解以及join方法等待的任务。它有两个重要的子类。
 * RecursiveAction和RecursiveTask。前者表示没有返回值的任务，后者有返回值。
 * 需要注意的问题：线程数量积累越多，导致性能严重下降；方法调用层次变多，最终导致栈溢出。
 *
 * @author i324779
 */
public class CountTask extends RecursiveTask<Long> {

    private static final int THRESHOLD = 1000;
    private long start;
    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0L;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (long i = start; i < end; i++) {
                sum += i;
            }
        } else { // 分解100个小任务
            long step = (start + end) / 100;
            ArrayList<CountTask> subTasks = new ArrayList<>();
            long pos = start;

            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                if (lastOne > end) {
                    lastOne = end;
                }

                CountTask subTask = new CountTask(pos, lastOne);
                pos += step + 1;
                subTasks.add(subTask);
                subTask.fork();
            }

            for (CountTask task : subTasks) {
                sum += task.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(0, 10000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);

        try {
            long res = result.get();
            System.out.println("Sum = " + res);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
