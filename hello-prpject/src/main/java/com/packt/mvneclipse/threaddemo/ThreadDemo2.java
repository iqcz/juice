package com.packt.mvneclipse.threaddemo;

/**
 * Lambda 启动线程
 * @author TurtusLi
 *
 */
public class ThreadDemo2 {

	public static void main(String ... args ) {
		Thread thread = new Thread(() -> {
			System.out.println("sub thread running");
		});
		
		thread.start();
		System.out.println(Thread.currentThread().getName());
	}
	
}
