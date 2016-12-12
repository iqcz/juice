package com.packt.mvneclipse.threaddemo;

/**
 * 有同步代码块的程序。
 * 但存在负载不均衡的情况，有的线程连续卖出多张票，而有的线程则无票可卖。
 * @author TurtusLi
 *
 */
public class ThreadSynchronization2 {

	public static void main(String[] args) {
		SynTestThread stt = new SynTestThread();
		new Thread(stt).start();
		new Thread(stt).start();
		new Thread(stt).start();
		new Thread(stt).start();
	}
}

class SynTestThread implements Runnable {

	private int tickets = 20;
	
	@Override
	public void run() {
		while(true) {
			synchronized(this) {
				if(tickets <= 0) {
					break;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "出票数：" + tickets);
				tickets--;
			}
		}
	}
	
}
