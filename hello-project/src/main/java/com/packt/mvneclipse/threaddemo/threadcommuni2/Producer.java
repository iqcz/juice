package com.packt.mvneclipse.threaddemo.threadcommuni2;

public class Producer implements Runnable {

	Person p = null;

	public Producer(Person p) {
		this.p = p;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				p.set("zhangsan", "male");
			} else {
				p.set("lisi", "female");
			}
		}
	}

}
