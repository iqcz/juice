package exam;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock来实现多线程同步
 * 
 * @author TurtusLi
 *
 */
public class Example013 {

    public static void main(String[] args) throws InterruptedException {

	final Lock lock = new ReentrantLock();
	lock.lock();

	Thread t1 = new Thread(() -> {
	    try {
		lock.lockInterruptibly();
//		lock.lock();
//		lock.tryLock()?
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	});

	t1.start();
	t1.interrupt();
	Thread.sleep(1);
    }

}
