package com.packt.java8inaction.bufferdemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {
    
    public static void main(String ... args) throws FileNotFoundException, IOException {
	// use ways before java 8
	System.out.println(processFile(new ReadOneLine()));
	System.out.println(processFile(new ReadTwoLines()));
	
	// use lambda expression
	System.out.println(processFile((b) -> b.readLine())); // read the first line.
	System.out.println(processFile((b) -> b.readLine() + b.readLine())); // read top 2 lines.
    }

    public static String processFile(BufferedReaderProcessor p) throws FileNotFoundException, IOException {
	try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
	    return p.process(br);
	} 		
	
    }
}
