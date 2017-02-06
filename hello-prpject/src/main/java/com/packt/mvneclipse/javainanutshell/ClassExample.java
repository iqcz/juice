package com.packt.mvneclipse.javainanutshell;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ClassExample {

    public static void main(String[] args) {

	System.out.println(commonAncestor(Integer.class, Double.class));
	//System.out.println(commonAncestor(LinkedList.class, ArrayList.class));
    }

    public static Class<?> commonAncestor(Class<?> c1, Class<?> c2) {

	if(c1 == null || c2 == null) {
	    return null;
	}

	if((c1.equals(c2))) {
	    return c1;
	}

	if(c1.isPrimitive() || c2.isPrimitive()) {
	    return null;
	}

	List<Class<?>> ancestors = new ArrayList<>();
	Class<?> c = c1;
	while(!c.equals(Object.class)) {
	    if(c.equals(c2)) {
		return c;
	    }
	    ancestors.add(c);
	    c = c.getSuperclass();
	}

	c = c2;
	// c != null 非常重要，如果不加，如果c1的继承层级比c2的要深，
	// 则c2 会一直赋值最后变成 Object，
	// 而 object 是没有 getSuperClass()方法的。
	while(c != null && !c.equals(Object.class)) {
	    for(Class<?> k : ancestors) {
		if(c.equals(k)) {
		    return c;
		}
		c = c.getSuperclass();
	    }
	}
	return Object.class;
    }
}
