package com.packt.mvneclipse.javainanutshell;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 给定指定路径下的 class 文件，找到该 class 存在的已经废弃的方法
 * 
 * @author Yanxue Li
 */
public class CustomClassloadingExamples {
    /*
     * 静态内部类
     */
    public static class DiskLoader extends ClassLoader {
	public DiskLoader() {
	    super(DiskLoader.class.getClassLoader());
	}

	public Class<?> loadFromDisk(String clzName) throws IOException {
	    byte[] b = Files.readAllBytes(Paths.get(clzName));

	    return defineClass(null, b, 0, b.length);
	}
    }

    /*
     * 找到类中存在的废弃的方法
     */
    public void findDeprecatedMethods(Class<?> clz) {
	for (Method m : clz.getMethods()) {
	    for (Annotation a : m.getAnnotations()) {
		if (a.annotationType() == Deprecated.class) {
		    System.out.println(m.getName());
		}
	    }
	}
    }

    /*
     * 此类没有具体的用处，只是用来标记为以个废弃的方法。
     */
    @Deprecated
    public void testMethod() {

    }

    public static void main(String[] args) throws IOException {
	CustomClassloadingExamples rfx = new CustomClassloadingExamples();

	DiskLoader dlr = new DiskLoader();
	Class<?> clz2Test = dlr
		.loadFromDisk("target/classes/com/packt/mvneclipse/javainanutshell/CustomClassloadingExamples.class");
	rfx.findDeprecatedMethods(clz2Test);

	/*
	if(args.length > 0) {
	    DiskLoader dlr = new DiskLoader();
	    Class<?> clz2Test = dlr.loadFromDisk(args[0]);
	    rfx.findDeprecatedMethods(clz2Test);
	}
	*/
    }
}
