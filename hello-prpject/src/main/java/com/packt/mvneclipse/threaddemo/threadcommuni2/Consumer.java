package com.packt.mvneclipse.threaddemo.threadcommuni2;

public class Consumer implements Runnable {

	Person p = null;
	
	public Consumer(Person p) {
		this.p = p;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			p.get();
		}
	}

}
