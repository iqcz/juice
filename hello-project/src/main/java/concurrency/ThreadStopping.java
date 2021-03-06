package concurrency;

/**
 * 使用volatile修饰标记标量
 * 使用属性来控制线程结束的方式。
 * @author i324779
 *
 */
public class ThreadStopping {

    public static void main(String[] args) {

        class StoppableThread extends Thread {

            private volatile boolean stopped;

            @Override
            public void run() {
                while (!stopped)
                    System.out.println("running");
            }

            void stopThread() {
                stopped = true;
            }
        }
        StoppableThread thd = new StoppableThread();
        thd.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        thd.stopThread();
    }
}
