package com.packt.java8inaction.methodreference;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class InstanceMethodReference {

	public static void main(String[] args) throws Exception {
		Callable<String> c  = () -> "hello";
		System.out.println(c.call());

	}
	
	public static String function(Supplier<String> supplier) {
		return supplier.get();
	}
	
	/**
	 * Lambda expression
	 */
	public void example4Lambda() {
		String x = "";
		function(() -> x.toString());
	}

	/**
	 * Method reference
	 */
	public void example4MethodReference() {
		String x = "";
		function(x::toString);
	}
	
	/**
	 * anonymous Class
	 */
	public void example4AnonymousClass() {
		String x = "";
		function(new Supplier<String>() {
			@Override
			public String get() {
				return x.toString();
			}
		});
	}
}
