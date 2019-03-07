package com.packt.mvneclipse.javainanutshell;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

public class MethodLookupExample {

    public static void main(String[] args) {
	Lookup l = MethodHandles.lookup();

	lookupDefineClass(l);
    }

    public static void lookupDefineClass(Lookup l) {
	MethodType mt = MethodType.methodType(Class.class, String.class, byte[].class, int.class, int.class);

	try {
	    MethodHandle mh = l.findVirtual(ClassLoader.class, "defineClass", mt);
	    System.out.println(mh);
	} catch (NoSuchMethodException | IllegalAccessException e) {
	    e.printStackTrace();
	}
    }

}
