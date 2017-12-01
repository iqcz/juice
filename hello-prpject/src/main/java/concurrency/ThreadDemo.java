package concurrency;

public class ThreadDemo {
    public static void main(String[] args) {
	Runnable r = () -> {
	    String name = Thread.currentThread().getName();
	    int count = 0;
	    while (!Thread.interrupted()) {
		System.out.println(name + ": " + count++);
	    }
	};
	
	Thread thdA = new Thread(r);
	Thread thdB = new Thread(r);
	thdA.start();
	thdB.start();
	
	/* 这种方式不好，浪费资源，改用sleep方法。
	while (true) {
	    double n = Math.random();
	    if (n >= 0.49999999 && n <= 0.50000001) {
		break;
	    }
	}
	*/
	try {
	    Thread.sleep(2000);
	} catch (InterruptedException ie) {
	}

	thdA.interrupt();
	thdB.interrupt();
    }
}