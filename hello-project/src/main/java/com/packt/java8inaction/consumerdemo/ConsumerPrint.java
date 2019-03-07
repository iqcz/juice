package com.packt.java8inaction.consumerdemo;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerPrint<T> {

    public static <T> void foreach(List<T> list, Consumer<T> c) {
	for(T t : list) {
	    c.accept(t);
	}
    }
}
