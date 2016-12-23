package com.packt.mvneclipse.threaddemo.threadcommuni3;

/**
 * use wait, notify.
 * 
 * @author TurtusLi
 *
 */
public class ThreadCommunication3 {

	public static void main(String[] args) {
		Person p = new Person();

		new Thread(new Producer(p)).start();
		new Thread(new Consumer(p)).start();
	}

}
