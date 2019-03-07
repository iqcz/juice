package com.packt.mvneclipse.javainanutshell;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 利用反射调用 Object 的hashCode 方法。
 * @author Yanxue Li
 *
 */
public class InvokeHashcodeMethod {

    public static void main(String[] args) {
	Object rcvr = "a";
	
	Class<?>[] argTypes = new Class[]{};
	Object[] arg = null;
	
	Method meth;
	try {
	    meth = rcvr.getClass().getMethod("hashCode", argTypes);
	    Object rct = meth.invoke(rcvr, arg);
	    
	    System.out.println(rct);
	} catch(NoSuchMethodException e) {
	    e.printStackTrace();
	} catch(SecurityException e) {
	    e.printStackTrace();
	} catch(IllegalAccessException e) {
	    e.printStackTrace();
	} catch(IllegalArgumentException e) {
	    e.printStackTrace();
	} catch(InvocationTargetException e) {
	    e.printStackTrace();
	}
	
    }

}
