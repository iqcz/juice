package com.packt.mvneclipse.threaddemo.threadcommuni2;

/**
 * 给Person类的get和set方法加上同步代码
 * @author TurtusLi
 *
 */
public class Person {

	private String name = "lisi";
	private String sex  = "female";
	
	public synchronized void set(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}
	
	public synchronized void get() {
		System.out.printf("%s--->%s\r", name, sex);
	}
	
}
