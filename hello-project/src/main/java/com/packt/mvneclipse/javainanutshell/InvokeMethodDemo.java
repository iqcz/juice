package com.packt.mvneclipse.javainanutshell;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeMethodDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
	    IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
	Class<?> clazz = null;

	clazz = Class.forName("com.packt.mvneclipse.javainanutshell.Person");

	Method method = clazz.getMethod("sayHello", String.class, int.class);

	String retVal = null;
	// 构造方法赋值
	// retVal = (String)method.invoke(clazz.getConstructor(String.class,
	// int.class).newInstance("Tim", 28), " Tim", 28);

	// set 方法赋值
	Person person = new Person();
	person.setName("Kelly");
	person.setAge(35);
	retVal = (String) method.invoke(person, "Tim", 28);

	System.out.println(retVal);
    }
}
