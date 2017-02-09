package com.packt.mvneclipse.javainanutshell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class RememberingList implements InvocationHandler {

    private final List<String> proxied = new ArrayList<>();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	String name = method.getName();

	switch (name) {
	case "clear":
	    return null;
	case "remove":
	case "removeAll":
	    return false;
	}

	return method.invoke(proxied, args);
    }

    public static void main(String... argss) {
	RememberingList hList = new RememberingList();
	@SuppressWarnings("unchecked")
	List<String> l = (List<String>) Proxy.newProxyInstance(List.class.getClassLoader(), new Class[] { List.class },
		hList);
	l.add("cat");
	l.add("bunny");
	l.clear();
	System.out.println(l);
    }
}
