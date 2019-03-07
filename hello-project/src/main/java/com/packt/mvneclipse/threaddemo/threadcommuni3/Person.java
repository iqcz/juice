package com.packt.mvneclipse.threaddemo.threadcommuni3;

public class Person {
	private String name = "lisi";
	private String sex = "female";

	private boolean beFull = false;

	public synchronized void set(String name, String sex) {
		if (beFull) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name;
		this.sex = sex;

		beFull = true;
		notify();
	}

	public synchronized void get() {
		if (!beFull) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("%s--->%s\r", name, sex);
		
		beFull = false;
		notify();
	}
}
