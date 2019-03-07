package com.packt.mvneclipse.javainanutshell;

public class Singleton {

	private static final Singleton instance = new Singleton();

	private static boolean initialized = false;

	private Singleton() {
		super();
	}

	private void init() {
		/* Do initialization */
	}

	// This method should be the only way to get a reference to the instance
	public static synchronized Singleton getInstance() {
		if (initialized) {
			return instance;
		}

		instance.init();
		initialized = true;

		return instance;
	}
}
