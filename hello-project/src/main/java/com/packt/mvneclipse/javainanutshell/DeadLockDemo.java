package com.packt.mvneclipse.javainanutshell;

/**
 * 死鎖範例
 * @author TurtusLi
 *
 */
class Zhangsan {

    public void say() {
	System.out.println("Zhangsan said to Lisi: give me pic, I give you book.");
    }

    public void get() {
	System.out.println("Zhangsan got pic.");
    }
}

class Lisi {
    public void say() {
	System.out.println("Lisi said to Zhangsan: give me book ,I give you pic.");
    }

    public void get() {
	System.out.println("Lisi got book.");
    }
}

public class DeadLockDemo implements Runnable {
    private static Zhangsan zs = new Zhangsan();

    private static Lisi ls = new Lisi();

    private boolean flag = false;

    @Override
    public void run() {
	if (flag) {
	    synchronized (zs) {
		zs.say();

		try {
		    Thread.sleep(500);
		} catch (InterruptedException ie) {
		    ie.printStackTrace();
		}

		synchronized (ls) {
		    zs.get();
		}
	    }
	} else {
	    synchronized (ls) {
		ls.say();

		try {
		    Thread.sleep(500);
		} catch (InterruptedException ie) {
		    ie.printStackTrace();
		}

		synchronized (zs) {
		    ls.get();
		}
	    }
	}
    }

    public static void main(String[] args) {
	DeadLockDemo dld_1 = new DeadLockDemo();
	DeadLockDemo dld_2 = new DeadLockDemo();

	dld_1.flag = true;
	dld_2.flag = false;

	Thread t1 = new Thread(dld_1);
	Thread t2 = new Thread(dld_2);
	t1.start();
	t2.start();
    }
}
