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
		
		// 判断制定方法上有无制定类型的Annotation存在
		if(toStringMethod.isAnnotationPresent(MyAnnotation.class)) {
			MyAnnotation myAnno = null;
			myAnno = toStringMethod.getAnnotation(MyAnnotation.class);
			String key = myAnno.key();
			String value = myAnno.value();
			
			System.out.printf("%s -> %s.", key, value);
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