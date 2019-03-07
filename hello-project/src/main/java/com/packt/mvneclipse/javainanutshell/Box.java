package com.packt.mvneclipse.javainanutshell;

public interface Box<T> {

	void box(T t);
	
	T unBox();
}
