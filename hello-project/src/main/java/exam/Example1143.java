package exam;

/**
 * 如何捕获一个线程抛出的异常？
 * @author TurtusLi
 *
 */
public class Example1143 {

    // 处理异常的handler
    private static Thread.UncaughtExceptionHandler handler = (Thread t, Throwable e) -> {
        System.out.println("Uncaught exception:" + e);
    };

    public static void main(String[] args) {
        Thread myThread = new MyThread();
        //设置捕获异常的handler
        myThread.setUncaughtExceptionHandler(handler);
        myThread.start();
    }

}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread will throw exception.");
        throw new RuntimeException("My own exception from thread.");
    }
}