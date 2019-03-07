package concurrency;

/**
 * 参见《疯狂Java讲义》
 * @author User
 *
 */
public class JoinThread extends Thread {

    public JoinThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + "->" + i);
        }
    }

    public static void main(String... args) throws InterruptedException {
        new JoinThread("新线程").start();

        for (int i = 0; i < 50; i++) {
            if (i == 20) {
                JoinThread jt = new JoinThread("被Join的线程");
                //JoinThread jt2 = new JoinThread("被Join的线程22222");
                jt.start();
                //jt2.start();
                // main线程调用了jt线程的join方法，main线程必须等jt执行结束以后才会向下执行
                jt.join();
                //jt2.join();
            }
            System.out.println(Thread.currentThread().getName() + "->" + i);
        }
    }
}