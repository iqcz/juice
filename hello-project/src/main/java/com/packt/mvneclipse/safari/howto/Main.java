package com.packt.mvneclipse.safari.howto;

public class Main {

	public static void main(String[] args) {
		Sub ying = new Sub();
		System.out.println(ying.age);
		ying.func();

		Base base = new Base();
		System.out.println(base.age);
		base.func();

		// 属性还是来自父类，但覆写的方法来自子类。
		Base bs = new Sub();
		System.out.println(bs.age);
		bs.func();
	}

}
