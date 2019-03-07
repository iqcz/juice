package book.artconcurrent.ch04;

/**
 * 简单线程池接口定义
 * @param <Job>
 */
public interface ThreadPool<Job extends Runnable> {

    // 执行一个Job，这个Job要实现Runnable接口
    void execute(Job job);

    // 关闭线程池
    void shutdown();

    // 添加工作中线程
    void addWorkers(int num);

    // 减少工作中线程
    void removeWorkers(int num);

    // 得到正在等在执行的任务数量
    int getJobSize();

}
