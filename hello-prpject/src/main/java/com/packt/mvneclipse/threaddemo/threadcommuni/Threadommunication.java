package com.packt.mvneclipse.threaddemo.threadcommuni;

/**
 * 此包下
 * @author TurtusLi
 *
 */
public class Threadommunication {

	public static void main(String ... args) {
		Person p = new Person();
		
		new Thread(new Producer(p)).start();
		new Thread(new Consumer(p)).start();
	}
}
