package com.packt.mvneclipse.threaddemo;

public class ThreadDemo1 {

	public static void main(String[] args) {
		new TestThread().start();

		for (int i = 0; i < 5; i++) {
			System.out.println("Main thread is running.");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class TestThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("TestThread is running.");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
