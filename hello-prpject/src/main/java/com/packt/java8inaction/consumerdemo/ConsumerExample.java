package com.packt.java8inaction.consumerdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
	Consumer<String> consumer = s -> System.out.println(s);
	
	List<String> names = new ArrayList<>();
	names.add("xiaoming");
	names.add("xiaoli");
	names.add(null);
	names.add("");
	names.add("xiaohua");
	
	ConsumerPrint.foreach(names, consumer);
    }

}
