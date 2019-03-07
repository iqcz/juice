package com.packt.mvneclipse.threaddemo;

import java.util.Scanner;

public class ThreadStatus implements Runnable {

	@Override
	public void run() {
		System.out.println("处于运行状态。");
		try(Scanner scanner = new Scanner(System.in)) {
		System.out.println("等待I/O，处于堵塞状态。");
		System.out.println("请输入字符串：");
		
		scanner.next();
		scanner.close(); // 不再等待I/O，重新进入就绪状态。
		System.out.println("结束阻塞状态，重新进入就绪状态，然后运行状态。");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("程序进入死亡状态。");
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new ThreadStatus());
		System.out.println("处于创建状态。");
		thread.start();
		System.out.println("处于就绪状态。");
	}

}
