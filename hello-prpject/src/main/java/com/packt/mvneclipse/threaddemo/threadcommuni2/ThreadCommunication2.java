package com.packt.mvneclipse.threaddemo.threadcommuni2;

public class ThreadCommunication2 {

	public static void main(String[] args) {
		Person p = new Person();
		
		new Thread(new Producer(p)).start();
		new Thread(new Consumer(p)).start();
	}

}
