package com.packt.mvneclipse.threaddemo;

/**
 * 沒有同步的線程
 * 线程不安全的程序
 * @author TurtusLi
 *
 */
public class ThreadSynchronization {

	public static void main(String[] args) {
		TicketThread ticketThread = new TicketThread();
		
		new Thread(ticketThread).start();
		new Thread(ticketThread).start();
		new Thread(ticketThread).start();
		new Thread(ticketThread).start();
	}

}

class TicketThread implements Runnable {

	private int ticket = 5;
	@Override
	public void run() {
		while (ticket > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "出票数：" + ticket);
			ticket -=1;
		}
	}
	
}