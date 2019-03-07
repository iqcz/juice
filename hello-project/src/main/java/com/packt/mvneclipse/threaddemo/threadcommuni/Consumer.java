package com.packt.mvneclipse.threaddemo.threadcommuni;

public class Consumer implements Runnable {

	Person p = null;
	
	public Consumer(Person p) {
		this.p = p;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.printf("%s--->%s\r", p.name, p.sex);
			sleep();
		}
	}

	private void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
