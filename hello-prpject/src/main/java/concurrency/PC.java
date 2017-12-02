package concurrency;

/**
 * 非常好的生产者-消费者使用多线程同步的代码
 * 其实，这些操作还是比较low-level的线程操作
 * 最好还是使用线程池等工具类。
 * @author i324779
 *
 */
public class PC {
    public static void main(String[] args) {
	Shared s = new Shared();
	new Producer(s).start();
	new Consumer(s).start();
    }
}

class Shared {
    private char c;
    private volatile boolean writeable = true;

    synchronized void setSharedChar(char c) {
	while (!writeable)
	    try {
		wait();
	    } catch (InterruptedException ie) {
	    }
	this.c = c;
	writeable = false;
	notify();
    }

    synchronized char getSharedChar() {
	while (writeable)
	    try {
		wait();
	    } catch (InterruptedException ie) {
	    }
	writeable = true;
	notify();
	return c;
    }
}

class Producer extends Thread {
    private final Shared s;

    Producer(Shared s) {
	this.s = s;
    }

    @Override
    public void run() {
	for (char ch = 'A'; ch <= 'Z'; ch++) {
	    synchronized (s) {
		s.setSharedChar(ch);
		System.out.println(ch + " produced by producer.");
	    }
	}
    }
}

class Consumer extends Thread {
    private final Shared s;

    Consumer(Shared s) {
	this.s = s;
    }

    @Override
    public void run() {
	char ch;
	do {
	    synchronized (s) {
		ch = s.getSharedChar();
		System.out.println(ch + " consumed by consumer.");
	    }
	} while (ch != 'Z');
    }
}