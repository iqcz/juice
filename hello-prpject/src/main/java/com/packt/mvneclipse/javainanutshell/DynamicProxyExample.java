package com.packt.mvneclipse.javainanutshell;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.nio.channels.Channel;

public class DynamicProxyExample {

    public static void main(String[] args) throws IOException {
	InvocationHandler h = (proxy, method, paras) -> {
	    String name = method.getName();
	    System.out.println("Called as : " + name);

	    switch (name) {
	    case "isOpen":
		return false;
	    case "close":
		return null;
	    }
	    return null;
	};

	Channel c = (Channel) Proxy.newProxyInstance(Channel.class.getClassLoader(), new Class[] { Channel.class }, h);
	c.isOpen();
	c.close();
    }

}
