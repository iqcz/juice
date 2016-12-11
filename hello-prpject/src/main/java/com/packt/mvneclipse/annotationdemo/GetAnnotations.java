package com.packt.mvneclipse.annotationdemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class GetAnnotations {

	public static void main(String... args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class<?> cls = Class.forName("com.packt.mvneclipse.annotationdemo.Info");
		Method toStringMethod = cls.getMethod("toString");
		Annotation[] ans = toStringMethod.getAnnotations();

		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}

class Info {
	@Override
	@Deprecated
	@SuppressWarnings("This is a warning.")
	@MyAnnotation(key = "root")
	public String toString() {
		return "Hello, world!";
	}
}