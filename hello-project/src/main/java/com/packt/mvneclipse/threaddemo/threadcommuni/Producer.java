package com.packt.mvneclipse.threaddemo.threadcommuni;

public class Producer implements Runnable {

	Person p = null;

	public Producer(Person p) {
		this.p = p;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				p.name = "zhangsan";
				sleep();
				p.sex = "male";
			} else {
				p.name = "lisi";
				sleep();
				p.sex = "female";
			}
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
