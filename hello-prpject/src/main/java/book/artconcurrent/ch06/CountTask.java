package book.artconcurrent.ch06;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join
 * @author i324779
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLE = 2;
    private final int start;
    private final int end;

    private CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        // 如果任务足够小就直接计算
        boolean canCompute = (end - start) <= THRESHOLE;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            leftTask.fork();
            rightTask.fork();

            // 等待子任务执行完，并得到结果。
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            // 合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 生成一个计算任务，负责计算1 + 2 + 3 + 4.
        CountTask task = new CountTask(1, 4);

        Future<Integer> result = forkJoinPool.submit(task);

        System.out.println(result.get());
    }
}
