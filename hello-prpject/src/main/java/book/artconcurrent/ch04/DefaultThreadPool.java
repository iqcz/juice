package book.artconcurrent.ch04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程池的本质就是使用了一个线程安全的工作队列连接工作者线程和客户端线程，
 * 客户端线程将任务放入工作队列后便返回，而工作者线程不断从工作队列上取出工作并执行。
 * 当工作队列为空时，所有工作者线程均等待在工作队列上，当有客户端提交了一个任务后会通知
 * 任意一个工作者线程，随着大量的任务被提交，更多的工作者线程会被唤醒。
 * @param <Job>
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    // 线程池最大限制数
    private static final int MAX_WORKER_NUMBERS = 10;
    // 线程池默认数量
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    // 线程池最少数量
    private static final int MIN_WORKER_NUMBERS = 1;
    // 工作列表，向里面插入工作
    private final LinkedList<Job> jobs = new LinkedList<>();
    // 工作者列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());
    // 工作者线程的数量
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    // 线程编号生成
    private final AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool() {
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num) {
        workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : num;
        initializeWorkers(workerNum);
    }

    public void execute(Job job) {
        if (job != null) {
            // 添加一个线程，然后进行通知
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }

    public void addWorkers(int num) {
        synchronized (jobs) {
            // 限制新增的Worker数量不能超过最大值
            if (num + this.workerNum > MAX_WORKER_NUMBERS) {
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum += num;
        }
    }

    public void removeWorkers(int num) {
        synchronized (jobs) {
            if (num >= this.workerNum) {
                throw new IllegalArgumentException("beyond workNum");
            }
            // 按照给定的数量停止Worker
            int count = 0;
            while (count < num) {
                workers.get(count).shutdown();
                count++;
            }
            this.workerNum -= count;
        }
    }

    public int getJobSize() {
        return jobs.size();
    }

    // 初始化线程工作者
    private void initializeWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    // 工作者，负责消费任务
    class Worker implements Runnable {

        // 是否工作
        private volatile boolean running = true;

        public void run() {
            while (running) {
                Job job;
                synchronized (jobs) {
                    // 如果工作者列表是空的，那么就wait
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException ex) {
                            // 感知到外部对WorkerThread的中断操作，返回
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    // 取出一个Job
                    job = jobs.removeFirst();
                }
                if (job != null) {
                    try {
                        job.run();
                    } catch (Exception ex) {
                        // 忽略Job执行中的Exception
                    }
                }
            }
        }

        public void shutdown() {
            running = false;
        }
    }
}
